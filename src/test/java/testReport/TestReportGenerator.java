package testReport;

import com.opencsv.CSVWriter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TestReportGenerator {

    private static long totalTestRun = 0;
    private static long totalTestPassed = 0;
    private static long totalTestFailed = 0;
    private static TreeMap<String, Map<String, Object>> testResultMap = new TreeMap();

    public static void printSuiteResultsInCsv(ISuite suite) {
        Collection<ISuiteResult> suiteResults = suite.getResults().values();
        for (ISuiteResult suiteResult : suiteResults) {
            printAllResults(suiteResult.getTestContext());
        }
        GenerateCsvReport();
    }

    private static void printAllResults(ITestContext context) {
        totalTestRun = context.getAllTestMethods().length;
        Set<ITestResult> passedTests = context.getPassedTests().getAllResults();
        if (passedTests != null && passedTests.size() > 0) {
            totalTestPassed = passedTests.size();
            setTestResult(passedTests, "Success");
        }
        Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
        if (failedTests != null && failedTests.size() > 0) {
            totalTestFailed = failedTests.size();
            setTestResult(failedTests, "Failure");
        }
        Set<ITestResult> skipedTests = context.getSkippedTests().getAllResults();
        if (skipedTests != null && skipedTests.size() > 0) {
            setTestResult(skipedTests, "Skipped");
        }
    }

    private static void setTestResult(Set<ITestResult> results, String status) {
        for (ITestResult result : results) {
            Map<String, Object> mp = new HashMap<String, Object>();
            mp.put("status", status);
            mp.put("executionTime", (result.getEndMillis() - result.getStartMillis()) / 1000);
            testResultMap.put(result.getMethod().getQualifiedName(), mp);
        }

    }

    private static void GenerateCsvReport() {
        File file1 = new File("testInfo.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile1 = new FileWriter(file1);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer1 = new CSVWriter(outputfile1);

            // adding header to csv
            String[] header1 = {"Test Name", "Status", "Execution Time (in sec)"};
            writer1.writeNext(header1);

            testResultMap.forEach((test, result) -> {
                Map<String, Object> mpr = result;
                String[] data1 = {test, mpr.get("status").toString(), mpr.get("executionTime").toString()};
                writer1.writeNext(data1);
            });
            writer1.writeNext(new String[]{"\n"});
            writer1.writeNext(new String[]{"\n"});
            writer1.writeNext(new String[]{"Test Summary"});
            writer1.writeNext(new String[]{"\n"});
            String[] header2 = {"TotalNumberOfTest", "TotalTestPassed", "TotalTestFailed"};
            writer1.writeNext(header2);
            String[] value2 = {totalTestRun + "", totalTestPassed + "", totalTestFailed + ""};
            writer1.writeNext(value2);
            // closing writer connection
            writer1.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
