/*
 * Created by IntelliJ IDEA.
 * Language: Java
 * Property of Umesh Gunasekara
 * @Author: SLMORA
 * @DateTime: 10/12/2022 11:34 AM
 */
package com.slmora.common.io.files;

import com.slmora.common.collections.MoraCollectionBuilder;
import com.slmora.common.logging.MoraLogger;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;

/**
 *  This Class created for Test {@link MoraFileReadAccess}
 *  Methods
 *  <ul>
 *      <li>{@link #beforeAllInit()}</li>
 *      <li>{@link #beforeEachInit(TestInfo, TestReporter)}</li>
 *      <li>{@link #afterEachEnd()}</li>
 *      <li>{@link #AfterAllInit()}</li>
 *  </ul>
 *  Tests
 *  <ul>
 *      <li>{@link #testCase01()} - When test {@link MoraFileReadAccess#readByFilePathToList_21(String)} method for content read</li>
 *      <li>{@link #testCase02()} - When test {@link MoraFileReadAccess#readByFilePathToList_451(String)} method for content read</li>
 *      <li>{@link #testCase03()} - When test {@link MoraFileReadAccess#readByFilePathToList_65(String)} method for content read</li>
 *      <li>{@link #testCase04()} - When test {@link MoraFileReadAccess#readByFilePathToList_0e(String)} method for content read</li>
 *      <li>{@link #testCase05()} - When test {@link MoraFileReadAccess#readByFilePathToList_21(String, Charset)} method for content read</li>
 *      <li>{@link #testCase06()} - When test {@link MoraFileReadAccess#readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_21(String, String, String)} method for content read</li>
 *      <li>{@link #testCase07()} - When test {@link MoraFileReadAccess#readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_65(String, String, String)} method for content read</li>
 *      <li>{@link #testCase08()} - When test {@link MoraFileReadAccess#readByFilePathToString_a(String)} method for content read</li>
 *      <li>{@link #testCase09()} - When test {@link MoraFileReadAccess#readByFilePathToStringOnClassLoader_b0c(String)} method for content read</li>
 *      <li>{@link #testCase10()} - When test {@link MoraFileReadAccess#readByFilePathToStringOnClassLoader_78d(String)} method for content read</li>
 *      <li>{@link #testCase11()} - When test {@link MoraFileReadAccess#readByFilePathToStringBuilder_21(String)} method for content read</li>
 *      <li>{@link #testCase12()} - When test {@link MoraFileReadAccess#readByFilePathToList_3(String, Charset)} method for content read</li>
 *      <li>{@link #testCase13()} - When test {@link MoraFileReadAccess#readByFilePathToStringBuilder_3(String, Charset)} method for content read</li>
 *      <li>{@link #testCase14()} - When test {@link MoraFileReadAccess#readByFilePathToList_7895(String)} method for content read</li>
 *      <li>{@link #testCase15()} - When test {@link MoraFileReadAccess#readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_7895(String, String, String)} method for content read</li>
 *      <li>{@link #testCase16()} - When test {@link MoraFileReadAccess#readByFilePathToString_7f(String)} method for content read</li>
 *      <li>{@link #testCase17()} - When test {@link MoraFileReadAccess#readByFilePathToString_21(String)} method for content read</li>
 *      <li>{@link #testCase18()} - When test {@link MoraFileReadAccess#readByFilePathToString_hij(String)} method for content read</li>
 *      <li>{@link #testCase19()} - When test {@link MoraFileReadAccess#readByFilePathToStringBuilderWithFiltersNotStartsWithAndNumberReplace_7895(String, String, String)} method for content read</li>
 *      <li>{@link #testCase20()} - When test {@link MoraFileReadAccess#readByInputStreamToStringBuilder_95(InputStream)} method for content read</li>
 *      <li>{@link #testCase21()} - When test {@link MoraFileReadAccess#readByInputStreamToStringBuilder_951(InputStream)} method for content read</li>
 *      <li>{@link #testCase22()} - When test {@link MoraFileReadAccess#readByUrlPathToStringBuilder_kl8(String)} method for content read</li>
 *      <li>{@link #testCase23()} - When test {@link MoraFileReadAccess#readByFilePathToString_g(String)} method for content read</li>
 *      <li>{@link #testCase24()} - When test {@link MoraFileReadAccess#readByFilePathToEncodedString_amn(String)} method for content read</li>
 *      <li>{@link #testCase25()} - When test {@link MoraFileReadAccess#readByFilePathToEncodedString_3mno(String, Charset)} method for content read</li>
 *      <li>{@link #testCase26()} - When test {@link MoraFileReadAccess#readByFilePathToEncodedString_3mno(String, Charset)} method for content read and decode</li>
 *      <li>{@link #testCase27()} - When test {@link MoraFileReadAccess#readByFilePathToString_r7(String)} method for content read and decode</li>
 *  </ul>
 *
 * @since   1.0
 *
 * <blockquote><pre>
 * <br>Version      Date            Editor              Note
 * <br>-------------------------------------------------------
 * <br>1.0          10/12/2022      SLMORA                Initial Code
 * </pre></blockquote>
 */
public class MoraFileReadAccessTest
{
    private final static MoraLogger LOGGER = MoraLogger.getLogger(MoraFileReadAccessTest.class);

    /**
     * <p>Supportive common attribute for the test class.</p>
     * */
    private TestInfo TEST_INFO;
    private TestReporter TEST_REPORTER;
    private long ELAPSED_TIME;

    /**
     * <P>Class specific attributes</p>
     * */
    private MoraFileReadAccess MORA_FILE_READ_ACCESS;
    private String SOURCE_PATH_BASE;

    /**
     * Runs this method before initialize this test class.<br>
     * This must be static because of this will execute before creates the instance of this class
     *
     * @since                   1.0
     * */
    @BeforeAll
    public static void beforeAllInit()
    {
        System.out.println("Before All Initiated........");
        System.out.println("Start Testing com.slmora.learn.file.common.util.file.MoraFileReadAccess .......");
    }

    /**
     * Runs this method before each test execution.
     *
     * @param testInfo          The test information injected by the test engine
     * @param testReporter      TReporter object injected by the test engine to
     *                          publish the test information
     * @since                   1.0
     * */
    @BeforeEach
    public void beforeEachInit(TestInfo testInfo, TestReporter testReporter)
    {
        this.TEST_INFO =testInfo;
        this.TEST_REPORTER =testReporter;
//        System.out.println("Running "+TEST_INFO.getDisplayName()+" with tags "+TEST_INFO.getTags());
        TEST_REPORTER.publishEntry("Running "+TEST_INFO.getDisplayName()+" with tags "+TEST_INFO.getTags()+ "\n");

        //Create MoraFileReadAccess instance
        this.MORA_FILE_READ_ACCESS =new MoraFileReadAccess();
        this.SOURCE_PATH_BASE = "D:/SLMORAWorkSpace/IntelliJProjects/slmora-io/mora-common-access-files/";
        System.out.println("Before Each MoraFileReadAccess Initiated........");
    }

    /**
     * Runs this method after each test execution.<br>
     * This shows the test method display name for every test cases.
     *
     * @since                   1.0
     * */
    @AfterEach
    public void afterEachEnd()
    {
        System.out.println("Test Completed "+ TEST_INFO.getDisplayName());
        System.out.println("After Each Clean Test........");
        System.out.println("Elapsed Time : " + ELAPSED_TIME + " ns");
        LOGGER.info("Elapsed Time for "+TEST_INFO.getDisplayName()+" : " +ELAPSED_TIME);
    }

    /**
     * This method runs After all Test Cases execution.<br>
     * This must be static because of this will execute after instance destroyed.
     *
     * @since                   1.0
     * */
    @AfterAll
    public static void AfterAllInit()
    {
        System.out.println("Finished Testing com.slmora.learn.file.common.util.file.MoraFileReadAccess .......");
        System.out.println("After All Initiated........");
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToList_21(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Optional<List<String>> readByFilePathToList_21(String filePath)\" method for content read")
    public void testCase01()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"/file/FILE_LIST_01.txt";

        // Initialise expected result
        List<String> expectedResult = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
                .add("4xm")
                .add("asf_stream")
                .add("RoQ")
                .add("aac")
                .add("ac3")
                .build();

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<List<String>> res = MORA_FILE_READ_ACCESS.readByFilePathToList_21(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            res.ifPresent(list -> list.forEach(System.out::println));
            assertAll(
                    () -> assertThat(res.get(),hasSize(5)),
                    () -> assertThat(res.get(),is(expectedResult)),
                    () -> assertThat(res.get(),containsInAnyOrder("aac","ac3","RoQ","asf_stream","4xm")),
                    () -> assertIterableEquals(expectedResult,res.get(),()->"the Result not equals with the Expected")
                    );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToList_451(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Optional<List<String>> readByFilePathToList_451(String filePath)\" method for content read")
    public void testCase02()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        // Initialise expected result
        List<String> expectedResult = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
                .add("4xm")
                .add("asf_stream")
                .add("RoQ")
                .add("aac")
                .add("ac3")
                .build();

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<List<String>> res = MORA_FILE_READ_ACCESS.readByFilePathToList_451(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            res.ifPresent(list -> list.forEach(System.out::println));
            assertAll(
                    () -> assertThat(res.get(),hasSize(5)),
                    () -> assertThat(res.get(),is(expectedResult)),
                    () -> assertThat(res.get(),containsInAnyOrder("aac","ac3","RoQ","asf_stream","4xm")),
                    () -> assertIterableEquals(expectedResult,res.get(),()->"the Result not equals with the Expected")
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToList_65(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Optional<List<String>> readByFilePathToList_65(String filePath)\" method for content read")
    public void testCase03()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        // Initialise expected result
        List<String> expectedResult = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
                .add("4xm")
                .add("asf_stream")
                .add("RoQ")
                .add("aac")
                .add("ac3")
                .build();

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<List<String>> res = MORA_FILE_READ_ACCESS.readByFilePathToList_65(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            res.ifPresent(list -> list.forEach(System.out::println));
            assertAll(
                    () -> assertThat(res.get(),hasSize(5)),
                    () -> assertThat(res.get(),is(expectedResult)),
                    () -> assertThat(res.get(),containsInAnyOrder("aac","ac3","RoQ","asf_stream","4xm")),
                    () -> assertIterableEquals(expectedResult,res.get(),()->"the Result not equals with the Expected")
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToList_0e(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Optional<List<String>> readByFilePathToList_0e(String filePath)\" method for content read")
    public void testCase04()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        // Initialise expected result
        List<String> expectedResult = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
                .add("4xm")
                .add("asf_stream")
                .add("RoQ")
                .add("aac")
                .add("ac3")
                .build();

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<List<String>> res = MORA_FILE_READ_ACCESS.readByFilePathToList_0e(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            res.ifPresent(list -> list.forEach(System.out::println));
            assertAll(
                    () -> assertThat(res.get(),hasSize(5)),
                    () -> assertThat(res.get(),is(expectedResult)),
                    () -> assertThat(res.get(),containsInAnyOrder("aac","ac3","RoQ","asf_stream","4xm")),
                    () -> assertIterableEquals(expectedResult,res.get(),()->"the Result not equals with the Expected")
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToList_21(String, Charset)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Optional<List<String>> readByFilePathToList_21(String filePath, Charset charset)\" method for content read")
    public void testCase05()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        // Initialise expected result
        List<String> expectedResult = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
                .add("4xm")
                .add("asf_stream")
                .add("RoQ")
                .add("aac")
                .add("ac3")
                .build();

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<List<String>> res = MORA_FILE_READ_ACCESS.readByFilePathToList_21(sourcePath,null);
            System.out.println("Content in the file :"+sourcePath);
            res.ifPresent(list -> list.forEach(System.out::println));
            assertAll(
                    () -> assertThat(res.get(),hasSize(5)),
                    () -> assertThat(res.get(),is(expectedResult)),
                    () -> assertThat(res.get(),containsInAnyOrder("aac","ac3","RoQ","asf_stream","4xm")),
                    () -> assertIterableEquals(expectedResult,res.get(),()->"the Result not equals with the Expected")
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_21(String, String, String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Optional<List<String>> readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_21(String filePath, String notStartsWith, String numberReplace)\" method for content read")
    public void testCase06()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_02.txt";

        // Initialise expected result
        List<String> expectedResult = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
                .add("4XM 0099 234 22")
                .add("4XM 0099 555 0099 TEST 0099")
                .add("ROQ 2233 TTR")
                .add("AC3 TEST 0099")
                .build();

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<List<String>> res = MORA_FILE_READ_ACCESS.readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_21(sourcePath,"MORA", "99");
            System.out.println("Content in the file :"+sourcePath);
            res.ifPresent(list -> list.forEach(System.out::println));
            assertAll(
                    () -> assertThat(res.get(),hasSize(4)),
                    () -> assertThat(res.get(),is(expectedResult)),
                    () -> assertThat(res.get(),containsInAnyOrder("4XM 0099 555 0099 TEST 0099","4XM 0099 234 22","AC3 TEST 0099","ROQ 2233 TTR")),
                    () -> assertIterableEquals(expectedResult,res.get(),()->"the Result not equals with the Expected")
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_65(String, String, String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Optional<List<String>> readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_65(String filePath, String notStartsWith, String numberReplace)\" method for content read")
    public void testCase07()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_02.txt";

        // Initialise expected result
        List<String> expectedResult = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
                .add("4XM 0099 234 22")
                .add("4XM 0099 555 0099 TEST 0099")
                .add("ROQ 2233 TTR")
                .add("AC3 TEST 0099")
                .build();

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<List<String>> res = MORA_FILE_READ_ACCESS.readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_65(sourcePath,"MORA", "99");
            System.out.println("Content in the file :"+sourcePath);
            res.ifPresent(list -> list.forEach(System.out::println));
            assertAll(
                    () -> assertThat(res.get(),hasSize(4)),
                    () -> assertThat(res.get(),is(expectedResult)),
                    () -> assertThat(res.get(),containsInAnyOrder("4XM 0099 555 0099 TEST 0099","4XM 0099 234 22","AC3 TEST 0099","ROQ 2233 TTR")),
                    () -> assertIterableEquals(expectedResult,res.get(),()->"the Result not equals with the Expected")
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToString_a(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"String readByFilePathToString_a(String filePath)\" method for content read")
    @Disabled
    public void testCase08()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        // Initialise expected result
//        List<String> valueList = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
//                .add("4xm")
//                .add("asf_stream")
//                .add("RoQ")
//                .add("aac")
//                .add("ac3")
//                .build();
//
//        String expectedResult = valueList.stream().reduce((a,b)->a.concat("\n").concat(b)).get();

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

//        String expectedResult = sb.toString();

        String expectedResult = new String("4xm\n" +
                "asf_stream\n" +
                "RoQ\n" +
                "aac\n" +
                "ac3");

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            String res = MORA_FILE_READ_ACCESS.readByFilePathToString_a(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res);
            System.out.println(res.trim().toCharArray().length);
            System.out.println(expectedResult.trim().toCharArray().length);
            assertEquals(expectedResult.trim(),res.trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToStringOnClassLoader_b0c(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"String readByFilePathToStringOnClassLoader_b0c(String fileName)\" method for content read")
    @Disabled
    public void testCase09()
    {
        // Initialise Path
        String sourceFileName = "FILE_LIST_03.txt";

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            String res = MORA_FILE_READ_ACCESS.readByFilePathToStringOnClassLoader_b0c(sourceFileName);
            System.out.println("Content in the file :"+sourceFileName);
            System.out.println(res);
            assertEquals(expectedResult.trim(),res.trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToStringOnClassLoader_78d(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"String readByFilePathToStringOnClassLoader_78d(String filePath)\" method for content read")
    @Disabled
    public void testCase10()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            String res = MORA_FILE_READ_ACCESS.readByFilePathToStringOnClassLoader_78d(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res);
            assertEquals(expectedResult.trim(),res.trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToStringBuilder_21(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"StringBuilder readByFilePathToStringBuilder_21(String filePath)\" method for content read")
    public void testCase11()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            StringBuilder res = MORA_FILE_READ_ACCESS.readByFilePathToStringBuilder_21(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res);
            assertEquals(expectedResult.trim(),res.toString().trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToList_3(String, Charset)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Optional<List<String>> readByFilePathToList_3(String filePath, Charset charset)\" method for content read")
    public void testCase12()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        // Initialise expected result
        List<String> expectedResult = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
                .add("4xm")
                .add("asf_stream")
                .add("RoQ")
                .add("aac")
                .add("ac3")
                .build();

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<List<String>> res = MORA_FILE_READ_ACCESS.readByFilePathToList_3(sourcePath,null);
            System.out.println("Content in the file :"+sourcePath);
            res.ifPresent(list -> list.forEach(System.out::println));
            assertAll(
                    () -> assertThat(res.get(),hasSize(5)),
                    () -> assertThat(res.get(),is(expectedResult)),
                    () -> assertThat(res.get(),containsInAnyOrder("aac","ac3","RoQ","asf_stream","4xm")),
                    () -> assertIterableEquals(expectedResult,res.get(),()->"the Result not equals with the Expected")
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToStringBuilder_3(String, Charset)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"StringBuilder readByFilePathToStringBuilder_3(String filePath, Charset charset)\" method for content read")
    public void testCase13()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            StringBuilder res = MORA_FILE_READ_ACCESS.readByFilePathToStringBuilder_3(sourcePath,null);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res);
            assertEquals(expectedResult.trim(),res.toString().trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToList_7895(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Optional<List<String>> readByFilePathToList_7895(String filePath)\" method for content read")
    public void testCase14()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        // Initialise expected result
        List<String> expectedResult = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
                .add("4xm")
                .add("asf_stream")
                .add("RoQ")
                .add("aac")
                .add("ac3")
                .build();

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<List<String>> res = MORA_FILE_READ_ACCESS.readByFilePathToList_7895(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            res.ifPresent(list -> list.forEach(System.out::println));
            assertAll(
                    () -> assertThat(res.get(),hasSize(5)),
                    () -> assertThat(res.get(),is(expectedResult)),
                    () -> assertThat(res.get(),containsInAnyOrder("aac","ac3","RoQ","asf_stream","4xm")),
                    () -> assertIterableEquals(expectedResult,res.get(),()->"the Result not equals with the Expected")
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_7895(String, String, String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Optional<List<String>> readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_7895(String filePath, String notStartsWith, String numberReplace)\" method for content read")
    public void testCase15()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_02.txt";

        // Initialise expected result
        List<String> expectedResult = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
                .add("4XM 0099 234 22")
                .add("4XM 0099 555 0099 TEST 0099")
                .add("ROQ 2233 TTR")
                .add("AC3 TEST 0099")
                .build();

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<List<String>> res = MORA_FILE_READ_ACCESS.readByFilePathToListWithFiltersNotStartsWithAndNumberReplace_7895(sourcePath,"MORA", "99");
            System.out.println("Content in the file :"+sourcePath);
            res.ifPresent(list -> list.forEach(System.out::println));
            assertAll(
                    () -> assertThat(res.get(),hasSize(4)),
                    () -> assertThat(res.get(),is(expectedResult)),
                    () -> assertThat(res.get(),containsInAnyOrder("4XM 0099 555 0099 TEST 0099","4XM 0099 234 22","AC3 TEST 0099","ROQ 2233 TTR")),
                    () -> assertIterableEquals(expectedResult,res.get(),()->"the Result not equals with the Expected")
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToString_7f(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"String readByFilePathToString_7f(String filePath)\" method for content read")
    @Disabled
    public void testCase16()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<String> opRes = MORA_FILE_READ_ACCESS.readByFilePathToString_7f(sourcePath);
            String res = opRes.isPresent()?opRes.get():null;
            System.out.println("Content in the file :"+sourcePath);
            opRes.ifPresent(str -> System.out.println(str));
            assertEquals(expectedResult.trim(),res.trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToString_21(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"String readByFilePathToString_21(String filePath)\" method for content read")
    @Disabled
    public void testCase17()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            String res = MORA_FILE_READ_ACCESS.readByFilePathToString_21(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res);
            System.out.println(res.trim().toCharArray().length);
            System.out.println(expectedResult.trim().toCharArray().length);
            assertEquals(expectedResult.trim(),res.trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToString_hij(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"String readByFilePathToString_hij(String filePath)\" method for content read")
    @Disabled
    public void testCase18()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            String res = MORA_FILE_READ_ACCESS.readByFilePathToString_hij(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res);
            System.out.println(res.trim().toCharArray().length);
            System.out.println(expectedResult.trim().toCharArray().length);
            assertEquals(expectedResult.trim(),res.trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToStringBuilderWithFiltersNotStartsWithAndNumberReplace_7895(String, String, String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"StringBuilder readByFilePathToStringBuilderWithFiltersNotStartsWithAndNumberReplace_7895(String filePath, String notStartsWith, String numberReplace)\" method for content read")
    public void testCase19()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_02.txt";

        // Initialise expected result
        StringBuilder sb = new StringBuilder()
                .append("4XM 0099 234 22")
                .append("\n")
                .append("4XM 0099 555 0099 TEST 0099")
                .append("\n")
                .append("ROQ 2233 TTR")
                .append("\n")
                .append("AC3 TEST 0099");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            StringBuilder res = MORA_FILE_READ_ACCESS.readByFilePathToStringBuilderWithFiltersNotStartsWithAndNumberReplace_7895(sourcePath,"MORA", "99");
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res);
            assertEquals(expectedResult.trim(),res.toString().trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByInputStreamToStringBuilder_95(InputStream)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"StringBuilder readByInputStreamToStringBuilder_95(InputStream inputStream)\" method for content read")
    public void testCase20()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("FILE_LIST_03.txt");

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            StringBuilder res1 = MORA_FILE_READ_ACCESS.readByInputStreamToStringBuilder_95(new FileInputStream(sourcePath));
            StringBuilder res2 = MORA_FILE_READ_ACCESS.readByInputStreamToStringBuilder_95(inputStream);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res1);
            URL realData = getClass().getClassLoader().getResource("FILE_LIST_03.txt");
            System.out.println("Content in the file :"+realData.getPath());
            System.out.println(res2);
            assertAll(
                    ()->assertEquals(expectedResult.trim(),res1.toString().trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res1),
                    ()->assertEquals(expectedResult.trim(),res2.toString().trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res2)
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByInputStreamToStringBuilder_951(InputStream)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"StringBuilder readByInputStreamToStringBuilder_951(InputStream inputStream)\" method for content read")
    public void testCase21()
    {
        // Initialise Path
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("FILE_LIST_03.txt");

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
//            StringBuilder res1 = MORA_FILE_ACCESS.getContentOfFileInSingleStringBuilderByInputStreamUsingBufferedReaderAndStreams(new FileInputStream(sourcePath));
            StringBuilder res2 = MORA_FILE_READ_ACCESS.readByInputStreamToStringBuilder_951(inputStream);
            System.out.println("Content in the file :"+getClass().getClassLoader().getResource("FILE_LIST_03.txt").getPath());
            System.out.println(res2);
            assertAll(
//                    ()->assertEquals(expectedResult.trim(),res1.toString().trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res1),
                    ()->assertEquals(expectedResult.trim(),res2.toString().trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res2)
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByUrlPathToStringBuilder_kl8(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"StringBuilder readByUrlPathToStringBuilder_kl8(String urlPath)\" method for content read")
    public void testCase22()
    {
        // Initialise Path
        String sourceUrlPath = "http://www.slmora.com/mora/webtest/FILE_LIST_04.txt";

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            StringBuilder res = MORA_FILE_READ_ACCESS.readByUrlPathToStringBuilder_kl8(sourceUrlPath);
            System.out.println("Content in the file :"+sourceUrlPath);
            System.out.println(res);
            assertEquals(expectedResult.trim(),res.toString().trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToString_g(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"String readByFilePathToString_g(String filePath)\" method for content read")
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_20)
    @Disabled
    public void testCase23()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            String res = MORA_FILE_READ_ACCESS.readByFilePathToString_g(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res);
            System.out.println(res.trim().toCharArray().length);
            System.out.println(expectedResult.trim().toCharArray().length);
            assertEquals(expectedResult.trim(),res.trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToEncodedString_amn(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"String readByFilePathToEncodedString_amn(String filePath)\" method for content read")
    @Disabled
    public void testCase24()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        // Initialise expected result
        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

//        String expectedResult = sb.toString();

//        String expectedResult = new String("4xm\n" +
//                "asf_stream\n" +
//                "RoQ\n" +
//                "aac\n" +
//                "ac3");

        String expectedResult = Base64.getEncoder().encodeToString(sb.toString().getBytes(StandardCharsets.UTF_8));

        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            String res = MORA_FILE_READ_ACCESS.readByFilePathToEncodedString_amn(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res);
            System.out.println(res.trim().toCharArray().length);
            System.out.println(expectedResult.trim().toCharArray().length);
            assertEquals(expectedResult.trim(),res.trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToEncodedString_3mno(String, Charset)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"String readByFilePathToEncodedString_3mno(String filePath, Charset charset)\" method for content read")
    @Disabled
    public void testCase25()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        // Initialise expected result
        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

//        String expectedResult = sb.toString();

//        String expectedResult = new String("4xm\n" +
//                "asf_stream\n" +
//                "RoQ\n" +
//                "aac\n" +
//                "ac3");

        String expectedResult = Base64.getEncoder().encodeToString(sb.toString().getBytes(StandardCharsets.UTF_8));
//        expectedResult = StringUtils.chop(expectedResult);

        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            String res = MORA_FILE_READ_ACCESS.readByFilePathToEncodedString_3mno(sourcePath, StandardCharsets.UTF_8);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res);
            System.out.println(res.trim().toCharArray().length);
            System.out.println(expectedResult.trim().toCharArray().length);
            assertEquals(expectedResult.trim(),res.trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToEncodedString_3mno(String, Charset)} method.
     * Test for read correct content for existing file path comparing with decoded string
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"String readByFilePathToEncodedString_3mno(String filePath, Charset charset)\" method for content read and decode")
    public void testCase26()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        // Initialise expected result
        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        String expectedResult = new String("4xm\n" +
//                "asf_stream\n" +
//                "RoQ\n" +
//                "aac\n" +
//                "ac3");

//        String expectedResult = Base64.getEncoder().encodeToString(sb.toString().getBytes(StandardCharsets.UTF_8));
//        expectedResult = StringUtils.chop(expectedResult);

        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            String encodedString = MORA_FILE_READ_ACCESS.readByFilePathToEncodedString_3mno(sourcePath, StandardCharsets.UTF_8);
            String res = new String(Base64.getDecoder().decode(encodedString), StandardCharsets.UTF_8);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res);
            System.out.println(res.trim().toCharArray().length);
            System.out.println(expectedResult.trim().toCharArray().length);
            assertEquals(expectedResult.trim(),res.trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToList_0pq(String, String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Optional<List<String>> readByFilePathToList_0pq(String filePath, String charsetName)\" method for content read")
    public void testCase27()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        // Initialise expected result
        List<String> expectedResult = MoraCollectionBuilder.fromCollection(new ArrayList<String>())
                .add("4xm")
                .add("asf_stream")
                .add("RoQ")
                .add("aac")
                .add("ac3")
                .build();

        long startTime = System.nanoTime();

        // Test
        try {
            Optional<List<String>> res = MORA_FILE_READ_ACCESS.readByFilePathToList_0pq(sourcePath, "UTF-8");
            System.out.println("Content in the file :"+sourcePath);
            res.ifPresent(list -> list.forEach(System.out::println));
            assertAll(
                    () -> assertThat(res.get(),hasSize(5)),
                    () -> assertThat(res.get(),is(expectedResult)),
                    () -> assertThat(res.get(),containsInAnyOrder("aac","ac3","RoQ","asf_stream","4xm")),
                    () -> assertIterableEquals(expectedResult,res.get(),()->"the Result not equals with the Expected")
            );
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToString_r7(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"StringBuilder readByFilePathToString_r7(String filePath)\" method for content read")
    @Disabled
    public void testCase28()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            StringBuilder res1 = MORA_FILE_READ_ACCESS.readByFilePathToString_r7(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res1);
            assertEquals(expectedResult.trim(),res1.toString().trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res1);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Test the {@link MoraFileReadAccess#readByFilePathToString_sij(String)} method.
     * Test for read correct content for existing file path
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"StringBuilder readByFilePathToString_sij(String filePath)\" method for content read")
    @Disabled
    public void testCase29()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        StringBuilder sb = new StringBuilder()
                .append("4xm")
                .append("\n")
                .append("asf_stream")
                .append("\n")
                .append("RoQ")
                .append("\n")
                .append("aac")
                .append("\n")
                .append("ac3");

        String expectedResult = sb.toString();

//        System.out.println(expectedResult);

        long startTime = System.nanoTime();

        // Test
        try {
            StringBuilder res1 = MORA_FILE_READ_ACCESS.readByFilePathToString_sij(sourcePath);
            System.out.println("Content in the file :"+sourcePath);
            System.out.println(res1);
            assertEquals(expectedResult.trim(),res1.toString().trim(),() -> "Expected ====> \n"+expectedResult+" \n but result is ====> \n"+res1);
//            assertThat();
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }
}
