package com.daling.util.file;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class PDFUtil {
	
	Logger log = LoggerFactory.getLogger(this.getClass());


	/**
	 * 给PDF加水印
	 * @param inputPath 源文件路径
	 * @param imageWaterPath 图片水印路径
	 * @param response
	 * @throws IOException
	 * @throws com.itextpdf.text.DocumentException
	 */
	public static void imageWatermark(String inputPath, String imageWaterPath, HttpServletResponse response) throws IOException, DocumentException {
		// 读取器
		PdfReader reader = new PdfReader(inputPath);
		// 解析器与输出
		PdfStamper stamp = new PdfStamper(reader, response.getOutputStream());
		// 页眉水印透明度设置
		PdfGState gs1 = new PdfGState();
		gs1.setFillOpacity(0.7f);

		// 正文水印透明度设置
		PdfGState gs2 = new PdfGState();
		gs2.setFillOpacity(0.1f);

		// 页眉图片水印
		Image imageHeader = Image.getInstance(IOUtils.toByteArray(new FileInputStream(imageWaterPath)));
		imageHeader.setAbsolutePosition(50, 760);
		//按比例缩放
		imageHeader.scalePercent(5);

		// 图片水印
		Image image = Image.getInstance(IOUtils.toByteArray(new FileInputStream(imageWaterPath)));
		image.setAbsolutePosition(120, 350);
		//按比例缩放
		image.scalePercent(20);

		int n = reader.getNumberOfPages();
		for(int i = 1; i <= n; i++) {
			// 拿到层,页数
			PdfContentByte pdfContentByte = stamp.getOverContent(i);
			// 图片水印 透明度
			pdfContentByte.setGState(gs1);
			pdfContentByte.addImage(imageHeader);
		}
		for(int i = 1; i <= n; i++) {
			// 拿到层,页数
			PdfContentByte pdfContentByte = stamp.getOverContent(i);
			// 图片水印 透明度
			pdfContentByte.setGState(gs2);
			pdfContentByte.addImage(image);
		}

		stamp.close();
		reader.close();
	}

}
