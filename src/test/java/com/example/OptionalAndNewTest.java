package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalAndNewTest {

	@Autowired
	TestDataRepository target;

	private static boolean prepared = false;

	@Before
	public void prepare() {

		if (!prepared) {

			target.deleteAll();

			{
				TestData d = new TestData("abc", "def");
				d.setId(1);
				target.save(d);
			}
			{
				TestData d = new TestData("ghi", "jkl");
				d.setId(2);
				target.save(d);
			}
			prepared = true;
		}
	}

	@Test
	public void _01_testOptional() {

		{
			Optional<TestData> actual = target.findOptionalById(1);
			assertThat(actual.get().getId(), is(1));
		}
		{
			Optional<TestData> actual = target.findOptionalById(9);
			assertThat(actual.isPresent(), is(false));
		}
	}

	@Test
	public void _02_testNew() {

		{
			TestDataSummary actual = target.findNewById(1);
			assertThat(actual.getId(), is(1));
		}
		{
			TestDataSummary actual = target.findNewById(9);
			assertThat(actual, is(nullValue()));
		}
	}

	@Test
	public void _03_testOptionalAndNew() {

		{
			Optional<TestDataSummary> actual = target.findOptionalAndNewById(1);
			assertThat(actual.isPresent(), is(true));
			assertThat(actual.get().getId(), is(1));
		}
		{
			Optional<TestDataSummary> actual = target.findOptionalAndNewById(9);
			assertThat(actual.isPresent(), is(false));
		}
	}
}
