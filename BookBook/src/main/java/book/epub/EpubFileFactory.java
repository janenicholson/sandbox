package book.epub;

import com.google.common.collect.Lists;

import book.epub.content.EpubContentOpfFile;
import book.epub.content.EpubNcxFile;
import book.epub.format.EpubContainerFile;
import book.epub.format.EpubMimeTypeFile;

public class EpubFileFactory {
	public static EpubFile create() {
		EpubFile epubFile = new EpubFile(new EpubMimeTypeFile(), new EpubContainerFile(), new EpubContentOpfFile(), new EpubNcxFile(), Lists.<PersistableFile>newArrayList(new PersistableFile() {
			@Override
			public String getFileName() {
				return "OEBPS/chapter1.html";
			}
			
			@Override
			public byte[] getContent() {
				return "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><title>Chapter One</title></head><body><h1>Chapter One</h1></body></html>".getBytes();
			}
		}));
		return epubFile;
	}
}
