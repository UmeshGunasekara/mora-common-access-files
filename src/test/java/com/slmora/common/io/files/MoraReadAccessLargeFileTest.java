/*
 * Created by IntelliJ IDEA.
 * Language: Java
 * Property of Umesh Gunasekara
 * @Author: SLMORA
 * @DateTime: 10/25/2022 7:21 PM
 */
package com.slmora.common.io.files;

import com.slmora.common.logging.MoraLogger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 *  This Class created for Test {@link MoraFileReadAccess} for Large File Access
 *  Methods
 *  <ul>
 *      <li>{@link #beforeAllInit()}</li>
 *      <li>{@link #beforeEachInit(TestInfo, TestReporter)}</li>
 *      <li>{@link #afterEachEnd()}</li>
 *      <li>{@link #AfterAllInit()}</li>
 *  </ul>
 *  Tests
 *  <ul>
 *      <li>....</li>
 *  </ul>
 *
 * @since   1.0
 *
 * <blockquote><pre>
 * <br>Version      Date            Editor              Note
 * <br>-------------------------------------------------------
 * <br>1.0          10/25/2022      SLMORA                Initial Code
 * </pre></blockquote>
 */
public class MoraReadAccessLargeFileTest
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
     * Console write content of file in string using {@link Files#lines(Path, Charset)} and {@link Stream}
     * on given {@code filePath} and {@code charset}.
     * In {@link Files#lines(Path, Charset)} internally using {@link FileChannel}.
     * In {@link Files#lines(Path)} internally using UTF-8 as default charset.
     * Using the {@link Files#lines(Path, Charset)} method, the contents of the file are read and processed
     * lazily so that only a small portion of the file is stored in memory at any given time.
     * <ul>
     *     <li>{@link MoraFileReadAccess#readByFilePathToList_21(String)}</li>
     *     <li>{@link MoraFileReadAccess#readByFilePathToList_21(String, Charset)}</li>
     *     <li>{@link MoraFileReadAccess#readByFilePathToStringBuilder_21(String)}</li>
     *     <li>{@link MoraFileReadAccess#readByFilePathToStringBuilder_21(String, Charset)}</li>
     *     <li>{@link MoraFileReadAccess#readByFilePathToString_21(String)}</li>
     *     <li>{@link MoraFileReadAccess#readByFilePathToString_21(String, Charset)}</li>
     * </ul>
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Stream<String> lines(Path path, Charset cs)\" method for large content read")
    public void testCase01()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        long startTime = System.nanoTime();

        // Test
        try (Stream<String> fileStream = Files.lines(Paths.get(sourcePath), StandardCharsets.UTF_8)) {
            System.out.println("Content in the file :"+sourcePath);
            fileStream.forEach(System.out::println);
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Console write content of file in string using {@link File}, {@link FileUtils#lineIterator(File, String)} and {@link LineIterator}
     * on given {@code filePath} and {@code charset}.
     * In {@link FileUtils#lineIterator(File, String)} internally using {@link File} and {@link FileInputStream} and
     * {@link IOUtils#lineIterator(InputStream, String)}.
     * The {@code charsetName} can be "US-ASCII", "ISO-8859-1", "UTF-8", "UTF-16BE", "UTF-16LE", "UTF-16".
     * <ul>
     *     <li>{@link MoraFileReadAccess#readByFilePathToList_0pq(String, String)}</li>
     * </ul>
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"LineIterator lineIterator(File file, String charsetName)\" method for large content read")
    public void testCase02()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        long startTime = System.nanoTime();

        // Test
        try (LineIterator lineIterator = FileUtils.lineIterator(new File(sourcePath), "UTF-8")) {
            while (lineIterator.hasNext()) {
                System.out.println(lineIterator.nextLine());
            }
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Console write content of file in string using {@link RandomAccessFile}, {@link FileChannel},
     * {@link ByteBuffer} on given {@code filePath}.
     * In {@link RandomAccessFile} internally using {@link File}.
     * To get {@link FileChannel} uses {@link RandomAccessFile#getChannel()} and
     * setup {@link ByteBuffer} using of {@link FileChannel} then read for {@link ByteBuffer} using
     * {@link FileChannel#read(ByteBuffer)} finally to flip the {@link ByteBuffer} use {@link ByteBuffer#flip()}.
     * Note that when we are reading the files in Stream or line by line, we are referring to the character-based
     * or text files. For reading the binary files, UTF-8 charset may corrupt the data.
     * To read large raw data files, such as movies or large images, we can use Java NIO’s
     * {@link ByteBuffer}  and {@link FileChannel} classes. Remember that you will need to try
     * different buffer sizes and pick that works best for you.
     * <ul>
     *     <li>{@link MoraFileReadAccess#readByFilePathToString_hij(String)}</li>
     * </ul>
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"LineIterator lineIterator(File file, String charsetName)\" method for large content read")
    public void testCase03()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        long startTime = System.nanoTime();

        // Test
        try (RandomAccessFile accessFile = new RandomAccessFile(sourcePath, "r");
             FileChannel channel = accessFile.getChannel()){
            int bufferSize = 1024;
            if (bufferSize > channel.size()) {
                bufferSize = (int) channel.size();
            }
            ByteBuffer buff = ByteBuffer.allocate(bufferSize);

            while (channel.read(buff)>0){
                buff.flip();
                for (int i = 0; i < buff.limit(); i++) {
                    System.out.print((char) buff.get());
                }
                buff.clear();
            }
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }

    /**
     * Console write content of file in string using {@link FileInputStream} and {@link Scanner}
     * on given {@code filePath}.
     * <ul>
     *     <li>{@link MoraFileReadAccess#readByFilePathToList_0e(String, Charset)}</li>
     * </ul>
     *
     * */
    @Test
    @Tag("FileAccess")
    @DisplayName("When test \"Scanner(InputStream source, Charset charset)\" method for large content read")
    public void testCase04()
    {
        // Initialise Path
        String sourcePath = SOURCE_PATH_BASE+"file/FILE_LIST_01.txt";

        long startTime = System.nanoTime();

        // Test
        try (FileInputStream inputStream = new FileInputStream(sourcePath);
             Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)){
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            LOGGER.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        }
        System.out.println();

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
    }
}
