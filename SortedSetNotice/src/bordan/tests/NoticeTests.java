package bordan.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bordan.SSNotice;

public class NoticeTests {
	SSNotice hi;
	@Before
	public void setUp() throws Exception {
		hi = new SSNotice("Subject", "Text", SSNotice.MEDIUM);
	}
	@Test
	public void testSSNoticeStringStringInt() {
		assertEquals(hi, new SSNotice("Subject", "Text", SSNotice.MEDIUM));
	}

	@Test
	public void testSSNotice() {
		hi = new SSNotice();
		assertEquals(hi, new SSNotice());
	}

	@Test
	public void testGetSubject() {
		assertEquals(hi.getSubject(),"Subject");
	}

	@Test
	public void testGetDate() {
		assertEquals(hi.getDate(), "24.11.2014");
	}

	@Test
	public void testGetText() {
		assertEquals(hi.getText(), "Text");
	}

	@Test
	public void testGetPriority() {
		assertEquals(hi.getPriority(), SSNotice.MEDIUM);
	}

	@Test
	public void testSetSubject() {
		hi.setSubject("No Subject");
		assertEquals(hi.getSubject(), "No Subject");
	}

	@Test
	public void testSetText() {
		hi.setText("No Text");
		assertEquals(hi.getText(), "No Text");
	}

	@Test
	public void testSetPriority() {
		hi.setPriority(SSNotice.REALTIME);
		assertEquals(hi.getPriority(), SSNotice.REALTIME);
	}

	@Test
	public void testEqualsObject() {
		assertEquals(hi.equals(new SSNotice("Subject", "Text", SSNotice.MEDIUM)), true);
		assertEquals(hi.equals(new SSNotice("No Subject", "No Text", SSNotice.REALTIME)), false);
	}

	@Test
	public void testCompareDate() {
		assertEquals(hi.compareDate(new SSNotice("Subject", "Text", SSNotice.MEDIUM)), SSNotice.SAME);
		assertEquals(hi.compareDate(new SSNotice("No Subject", "No Text", SSNotice.REALTIME)), SSNotice.SAME);
	}

	@Test
	public void testCompareTo() {
		assertEquals(hi.compareTo(new SSNotice("Subject", "Text", SSNotice.MEDIUM)), 0);
		assertEquals(hi.compareTo(new SSNotice("No Subject", "No Text", SSNotice.REALTIME)), "Subject".compareTo("No Subject"));
	}

	@Test
	public void testCompare() {
		assertEquals(hi.compare(hi, new SSNotice("Subject", "Text", SSNotice.MEDIUM)), 0);
		assertEquals(hi.compare(hi, new SSNotice("No Subject", "No Text", SSNotice.REALTIME)), 1);
		assertEquals(hi.compare(hi, new SSNotice("No Subject", "No Text", SSNotice.LOW)), -1);
	}

}
