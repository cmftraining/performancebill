package tdd.performancebill.presentation;

import org.junit.Test;
import tdd.performancebill.presentation.PerformanceBillController;

import static org.junit.Assert.*;

public class PerformanceBillControllerTest {

    @Test
    public void createBill() {
        assertEquals(1,1);
    }

//    @Test
//    public void calTragedyAmount_大于20人时_加收人头费() {
//        verifyCalTragedyAmount(21, 41000);
//    }
//
//    @Test
//    public void calTragedyAmount_不大于20人时_不加收人头费() {
//        verifyCalTragedyAmount(20, 40000);
//    }
//
//    private void verifyCalTragedyAmount(int audienceNum, int expected) {
//        PerformanceBillController sut = new PerformanceBillController();
//
//        int actual = sut.calTragedyAmount(audienceNum);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void calThisVolumeCredits_当大于30人且为喜剧时_则按人头积分() {
//        PerformanceBillController sut = new PerformanceBillController();
//
//        int actual = sut.calThisVolumeCredits(31, "comedy");
//
//
//        assertEquals(7, actual);
//
//    }

}