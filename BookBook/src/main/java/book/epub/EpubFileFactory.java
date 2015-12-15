package book.epub;

import com.google.common.collect.Lists;

import book.epub.format.EpubContainerFile;
import book.epub.format.EpubContentOpfFile;
import book.epub.format.EpubMimeTypeFile;
import book.epub.format.EpubNcxFile;

public class EpubFileFactory {
	public static EpubView create(String id) {
		EpubView epubFile = new EpubView(new EpubMimeTypeFile(), new EpubContainerFile(), new EpubContentOpfFile(), new EpubNcxFile(), Lists.<PersistableFile>newArrayList(new PersistableFile() {
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
