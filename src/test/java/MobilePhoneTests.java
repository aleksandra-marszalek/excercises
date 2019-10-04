import calculator.model.Input;
import calculator.service.BasicOperationService;
import calculator.service.ComplicatedOperationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.internal.matchers.Null;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(JUnit4.class)
public class MobilePhoneTests {

    private MobilePhone mobilePhone = new MobilePhone();


    public ArrayList<String> setupListThree(String a, String b, String c) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        return arrayList;
    }

    public ArrayList<String> setupListFour(String a, String b, String c, String d) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        arrayList.add(d);
        return arrayList;
    }

    //setContactList and getContactList Tests
    @Test
    public void setgetContactListTest() {
        ArrayList<String> NameList = setupListThree("a", "b", "c");
        mobilePhone.setContactList(NameList);
        assertEquals(mobilePhone.getContactList(), NameList);
    }

    @Test
    public void setgetNumbersListTest() {
        ArrayList<String> NumberList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setNumbersList(NumberList);
        assertEquals(mobilePhone.getNumbersList(), NumberList);
    }

    //printContactTest
    //Just verifies that the method runs and doesn't edit the Lists
    @Test
    public void printContactsTest() {
        ArrayList<String> addNameList = setupListThree("a", "b", "c");
        ArrayList<String> addNumbersList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setContactList(addNameList);
        mobilePhone.setNumbersList(addNumbersList);
        mobilePhone.printContacts();
        assertEquals(mobilePhone.getContactList(), addNameList);
        assertEquals(mobilePhone.getNumbersList(), addNumbersList);
    }


    //addContactTests
    @Test
    public void addContactTest() {
        ArrayList<String> addNameList = setupListThree("a", "b", "c");
        ArrayList<String> addNumbersList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setContactList(addNameList);
        mobilePhone.setNumbersList(addNumbersList);
        ArrayList<String> addNameListVerify = setupListFour("a", "b", "c", "d");
        ArrayList<String> addNumbersListVerify = setupListFour("11111111111", "22222222222", "33333333333", "44444444444");
        mobilePhone.addContact("d", "44444444444");
        assertEquals(mobilePhone.getContactList(), addNameListVerify);
        assertEquals(mobilePhone.getNumbersList(), addNumbersListVerify);
    }

    @Test
    public void addContactTestRepeatName() {
        ArrayList<String> addNameList = setupListThree("a", "b", "c");
        ArrayList<String> addNumbersList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setContactList(addNameList);
        mobilePhone.setNumbersList(addNumbersList);
        mobilePhone.addContact("a", "44444444444");
        assertEquals(mobilePhone.getContactList(), addNameList);
        assertEquals(mobilePhone.getNumbersList(), addNumbersList);
    }

    @Test
    public void addContactTestRepeatNumber() {
        ArrayList<String> addNameList = setupListThree("a", "b", "c");
        ArrayList<String> addNumbersList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setContactList(addNameList);
        mobilePhone.setNumbersList(addNumbersList);
        mobilePhone.addContact("d", "33333333333");
        assertEquals(mobilePhone.getContactList(), addNameList);
        assertEquals(mobilePhone.getNumbersList(), addNumbersList);
    }

    @Test
    public void addContactTestRepeatNameAndNumber() {
        ArrayList<String> addNameList = setupListThree("a", "b", "c");
        ArrayList<String> addNumbersList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setContactList(addNameList);
        mobilePhone.setNumbersList(addNumbersList);
        mobilePhone.addContact("b", "22222222222");
        assertEquals(mobilePhone.getContactList(), addNameList);
        assertEquals(mobilePhone.getNumbersList(), addNumbersList);
    }

    //findContactTests
    @Test
    public void findContactTest() {
        ArrayList<String> findNameList = setupListThree("a", "b", "c");
        mobilePhone.setContactList(findNameList);
        assertThat(mobilePhone.findContact("a"), is(0));
    }

    @Test
    public void findContactFailTest() {
        ArrayList<String> findNameList = setupListThree("a", "b", "c");
        mobilePhone.setContactList(findNameList);
        assertThat(mobilePhone.findContact("d"), is(-1));
    }

    //findNumberTests
    @Test
    public void findNumberTest() {
        ArrayList<String> findNumberList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setContactList(findNumberList);
        assertThat(mobilePhone.findContact("33333333333"), is(2));
    }

    @Test
    public void findNumberFailTest() {
        ArrayList<String> findNumberList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setContactList(findNumberList);
        assertThat(mobilePhone.findContact("44444444444"), is(-1));
    }

    //removeContact Tests
    @Test
    public void removeContactTest() {
        ArrayList<String> removeNameList = setupListFour("a", "b", "c", "d");
        ArrayList<String> removeNumbersList = setupListFour("11111111111", "22222222222", "33333333333", "44444444444");
        mobilePhone.setContactList(removeNameList);
        mobilePhone.setNumbersList(removeNumbersList);
        mobilePhone.removeContact("a");
        ArrayList<String> removeNameListVerify = setupListThree("b", "c", "d");
        ArrayList<String> removeNumbersListVerify = setupListThree("22222222222", "33333333333", "44444444444");
        assertEquals(mobilePhone.getContactList(), removeNameListVerify);
        assertEquals(mobilePhone.getNumbersList(), removeNumbersListVerify);
    }

    @Test
    public void removeContactTestFail() {
        ArrayList<String> removeNameList = setupListFour("a", "b", "c", "d");
        ArrayList<String> removeNumbersList = setupListFour("11111111111", "22222222222", "33333333333", "44444444444");
        mobilePhone.setContactList(removeNameList);
        mobilePhone.setNumbersList(removeNumbersList);
        mobilePhone.removeContact("e");
        ArrayList<String> removeNameListVerify = setupListFour("a", "b", "c", "d");
        ArrayList<String> removeNumbersListVerify = setupListFour("11111111111", "22222222222", "33333333333", "44444444444");
        assertEquals(mobilePhone.getContactList(), removeNameListVerify);
        assertEquals(mobilePhone.getNumbersList(), removeNumbersListVerify);
    }

    //replaceContactName Tests
    @Test
    public void replaceContactNameTest() {
        ArrayList<String> replaceNameList = setupListThree("a", "b", "c");
        ArrayList<String> replaceNumberList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setContactList(replaceNameList);
        mobilePhone.setNumbersList(replaceNumberList);
        mobilePhone.replaceContactName("d", "b");
        ArrayList<String> replaceNameListVerify = setupListThree("a", "d", "c");
        ArrayList<String> replaceNumberListVerify = setupListThree("11111111111", "22222222222", "33333333333");
        assertEquals(mobilePhone.getContactList(), replaceNameListVerify);
        assertEquals(mobilePhone.getNumbersList(), replaceNumberListVerify);
    }

    @Test
    public void replaceContactNameFailTest() {
        ArrayList<String> replaceNameList = setupListThree("a", "b", "c");
        ArrayList<String> replaceNumberList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setContactList(replaceNameList);
        mobilePhone.setNumbersList(replaceNumberList);
        mobilePhone.replaceContactName("e", "d");
        ArrayList<String> replaceNameListVerify = setupListThree("a", "b", "c");
        ArrayList<String> replaceNumberListVerify = setupListThree("11111111111", "22222222222", "33333333333");
        assertEquals(mobilePhone.getContactList(), replaceNameListVerify);
        assertEquals(mobilePhone.getNumbersList(), replaceNumberListVerify);
    }

    //replaceContactNumber Test
    @Test
    public void replaceContactNumberTest() {
        ArrayList<String> replaceNameList = setupListThree("a", "b", "c");
        ArrayList<String> replaceNumberList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setContactList(replaceNameList);
        mobilePhone.setNumbersList(replaceNumberList);
        mobilePhone.replaceContactNumber("44444444444", "a");
        ArrayList<String> replaceNameListVerify = setupListThree("a", "b", "c");
        ArrayList<String> replaceNumberListVerify = setupListThree("44444444444", "22222222222", "33333333333");
        assertEquals(mobilePhone.getContactList(), replaceNameListVerify);
        assertEquals(mobilePhone.getNumbersList(), replaceNumberListVerify);
    }

    @Test
    public void replaceContactNumberFail() {
        ArrayList<String> replaceNameList = setupListThree("a", "b", "c");
        ArrayList<String> replaceNumberList = setupListThree("11111111111", "22222222222", "33333333333");
        mobilePhone.setContactList(replaceNameList);
        mobilePhone.setNumbersList(replaceNumberList);
        mobilePhone.replaceContactNumber("44444444444", "d");
        ArrayList<String> replaceNameListVerify = setupListThree("a", "b", "c");
        ArrayList<String> replaceNumberListVerify = setupListThree("11111111111", "22222222222", "33333333333");
        assertEquals(mobilePhone.getContactList(), replaceNameListVerify);
        assertEquals(mobilePhone.getNumbersList(), replaceNumberListVerify);
    }
}
