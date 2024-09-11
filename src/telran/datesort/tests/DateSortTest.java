package telran.datesort.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

class DateSortTest {

	@Test
	void test() {
		String[] dates = { "07-05-1990", "28-01-2010", "11-08-1990", "15-01-2010", "16/06/1970" };
		String[] expected = { "16/06/1970", "07-05-1990", "11-08-1990", "15-01-2010", "28-01-2010" };
		Comparator<String> comp = (d1, d2) -> {
//			int year = d1.substring(d1.length()-4).compareTo(d2.substring(d2.length()-4));
//			int month = d1.substring(3, 5).compareTo(d2.substring(3, 5));
//			int day = d1.substring(0, 2).compareTo(d2.substring(0, 2));
//			if (year < 0) {
//				return -1;
//			} else if (month < 0 && year == 0) {
//				return -1;
//
//			}
//			return (day < 0 && month == 0) ? -1 : 0;

			int d1year = Integer.parseInt(d1.substring(d1.length() - 4));
			int d2year = Integer.parseInt(d2.substring(d1.length() - 4));
			int d1month = Integer.parseInt(d1.substring(3, 5));
			int d2month = Integer.parseInt(d2.substring(3, 5));
			int d1day = Integer.parseInt(d1.substring(0, 2));
			int d2day = Integer.parseInt(d2.substring(0, 2));

			if (d1year != d2year) {
				return Integer.compare(d1year, d2year);
			} else if (d1month != d2month) {
				return Integer.compare(d1month, d2month);
			}

			return Integer.compare(d1day, d2day);

		};

		Arrays.sort(dates, comp);
		System.out.println("Dates after sort:");
		for (String data : dates) {
			System.out.println(data);

		}
		System.out.println();
		assertArrayEquals(expected, dates);
	}

}
