package com.ExcelProject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;
import jakarta.persistence.spi.PersistenceProvider;
public class CSVHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "priority", "reason", "vendor_id", "vendor_name", "scan_id", "cluster", "country",
			"document_no", "company_code", "type", "total_amnt", "currency", "po_no", "scan_date", "existing_status",
			"existing_comments" };
//method-1
	public static boolean hasCSVFormat(MultipartFile file) {
		if (TYPE.equals(file.getContentType()) || file.getContentType().equals("application/vnd.ms-excel")) {
			return true;
		}

		return false;
	}
//method-2
	public static List<ExcelProjectDetails> csvToTutorials(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<ExcelProjectDetails> developerTutorialList = new ArrayList<>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				ExcelProjectDetails developerTutorial = new ExcelProjectDetails(

						csvRecord.get("priority"),
						csvRecord.get("reason"), 
						Long.parseLong(csvRecord.get("vendor_id")),
						csvRecord.get("vendor_name"),
						Long.parseLong(csvRecord.get("scan_id")),
						csvRecord.get("cluster"), 
						csvRecord.get("country"),
						csvRecord.get("document_no"),
						csvRecord.get("company_code"), 
						csvRecord.get("type"),
						Double.parseDouble(csvRecord.get("total_amnt")),
						csvRecord.get("currency"),
						csvRecord.get("po_no"), 
					    csvRecord.get("scan_date"),
						csvRecord.get("existing_status"),
						csvRecord.get("existing_comments")
						
						);

				developerTutorialList.add(developerTutorial);
			}

			return developerTutorialList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

	
	
	//method-3
	public static ByteArrayInputStream tutorialsToCSV(List<ExcelProjectDetails> developerTutorialList) {
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			for (ExcelProjectDetails developerTutorial : developerTutorialList) {
				List<String> data = Arrays.asList(
						developerTutorial.getPriority(), 
						developerTutorial.getReason(),
						String.valueOf(developerTutorial.getVendor_id()),
						developerTutorial.getVendor_name(), 
						String.valueOf(developerTutorial.getScan_id()),
						developerTutorial.getCluster(),
						developerTutorial.getCountry(),
						developerTutorial.getDocument_no(),
						developerTutorial.getCompany_code(),
						developerTutorial.getType(),
						String.valueOf(developerTutorial.getTotal_amnt()),
						developerTutorial.getCurrency(),
						developerTutorial.getPo_no(),
						developerTutorial.getScan_date(),
						developerTutorial.getExisting_status(),
						developerTutorial.getExisting_comments()
						);

				csvPrinter.printRecord(data);
			}

			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}
}
