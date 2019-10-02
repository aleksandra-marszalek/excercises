import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Scanner;


@RunWith(JUnit4.class)
public class ListCreationTest {

    /* Tests Required:
        For GetN
            - Positive N
            - Negative N
            - N = 0
            - Non Integer
        For GetL
            - Correct Input
            - Non Integer
            - Different Length to N
        For GetQ
            - Positive Q
            - Negative Q
            - Q = 0
            - Non Integer
        For insertDelete
            - Insert
            - Delete
            - Wrong Input
        For outputFinalList
            - Correct Input
            - Incorrect Input
    */
    @Mock

    Scanner scanTest;

    @Test
    public void testGetN(){
        ListCreation listCreation = new ListCreation();
        Mockito.when(scanTest.nextInt()).thenReturn(1);
        Mockito.doNothing().when(scanTest.nextLine());

        assertEquals(listCreation.getN(scanTest), 1);
    }

}
