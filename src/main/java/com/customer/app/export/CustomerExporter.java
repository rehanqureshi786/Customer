package com.customer.app.export;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.customer.app.model.CustomerModel;

public class CustomerExporter {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<CustomerModel> listCustomer;

	public CustomerExporter(List<CustomerModel> listCustomer) {
		super();
		this.listCustomer = listCustomer;
		workbook = new XSSFWorkbook();

	}

	private void writeHeaderLine() {
		sheet = workbook.createSheet();

		Row row = sheet.createRow(0);

		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);

		CellStyle style = workbook.createCellStyle();
		style.setFont(font);

		createCell(row, 0, "Customer ID", style);
		createCell(row, 1, "Customer Name", style);
		createCell(row, 2, "Customer Email", style);
		createCell(row, 3, "Customer Phone", style);

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		// TODO Auto-generated method stub
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else {
			cell.setCellValue((String) value);
		}

		cell.setCellStyle(style);
	}

	private void writeDataLines() {
		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(12);
		style.setFont(font);

		for (CustomerModel model : listCustomer) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;

			createCell(row, columnCount++, model.getId(), style);
			createCell(row, columnCount++, model.getName(), style);
			createCell(row, columnCount++, model.getEmail(), style);
			createCell(row, columnCount++, model.getPhone(), style);
		}

	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

}
