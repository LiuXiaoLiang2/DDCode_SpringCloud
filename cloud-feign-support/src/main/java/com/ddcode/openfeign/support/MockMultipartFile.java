package com.ddcode.openfeign.support;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * Mock implementation of the {@link MultipartFile}
 * interface.
 *
 * <p>Useful in conjunction with a {@link MockMultipartHttpServletRequest}
 * for testing application controllers that access multipart uploads.
 *
 * @author Juergen Hoeller
 * @author Eric Crampton
 * @since 2.0
 * @see MockMultipartHttpServletRequest
 */
public class MockMultipartFile implements MultipartFile {

	private final String name;

	private String originalFilename;

	@Nullable
	private String contentType;

	private final byte[] content;


	/**
	 * Create a new MockMultipartFile with the given content.
	 * @param name the name of the file
	 * @param content the content of the file
	 */
	public MockMultipartFile(String name, @Nullable byte[] content) {
		this(name, "", null, content);
	}

	/**
	 * Create a new MockMultipartFile with the given content.
	 * @param name the name of the file
	 * @param contentStream the content of the file as stream
	 * @throws IOException if reading from the stream failed
	 */
	public MockMultipartFile(String name, InputStream contentStream) throws IOException {
		this(name, "", null, FileCopyUtils.copyToByteArray(contentStream));
	}

	/**
	 * Create a new MockMultipartFile with the given content.
	 * @param name the name of the file
	 * @param originalFilename the original filename (as on the client's machine)
	 * @param contentType the content type (if known)
	 * @param content the content of the file
	 */
	public MockMultipartFile(
			String name, @Nullable String originalFilename, @Nullable String contentType, @Nullable byte[] content) {

		Assert.hasLength(name, "Name must not be null");
		this.name = name;
		this.originalFilename = (originalFilename != null ? originalFilename : "");
		this.contentType = contentType;
		this.content = (content != null ? content : new byte[0]);
	}

	/**
	 * Create a new MockMultipartFile with the given content.
	 * @param name the name of the file
	 * @param originalFilename the original filename (as on the client's machine)
	 * @param contentType the content type (if known)
	 * @param contentStream the content of the file as stream
	 * @throws IOException if reading from the stream failed
	 */
	public MockMultipartFile(
			String name, @Nullable String originalFilename, @Nullable String contentType, InputStream contentStream)
			throws IOException {

		this(name, originalFilename, contentType, FileCopyUtils.copyToByteArray(contentStream));
	}


	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getOriginalFilename() {
		return this.originalFilename;
	}

	@Override
	@Nullable
	public String getContentType() {
		return this.contentType;
	}

	@Override
	public boolean isEmpty() {
		return (this.content.length == 0);
	}

	@Override
	public long getSize() {
		return this.content.length;
	}

	@Override
	public byte[] getBytes() throws IOException {
		return this.content;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(this.content);
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		FileCopyUtils.copy(this.content, dest);
	}


}
