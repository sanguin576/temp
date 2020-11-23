package com.dummy.spring;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.dummy.exception.dummyBusinessException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class AbstractITextPdfView extends AbstractView
{
    public AbstractITextPdfView( )
    {
        setContentType( "application/pdf" );
    }

    @Override
    protected boolean generatesDownloadContent( )
    {
        return true;
    }

    @Override
    protected void renderMergedOutputModel( Map<String, Object> model, HttpServletRequest request, HttpServletResponse response ) throws Exception
    {
        // IE workaround: write into byte array first.
        ByteArrayOutputStream baos = createTemporaryOutputStream( );

        // Apply preferences and build metadata.
        Document document = newDocument( );

        PdfWriter writer = newWriter( document, baos );
        prepareWriter(writer);
        buildPdfMetadata( model, document, request );

        // Build PDF document.
        document.open( );
        buildPdfDocument( model, document, writer, request, response );
        document.close( );
        addPagesNumbers( model, document, writer, request, response, baos );

        // Flush to HTTP response.
        writeToResponse( response, baos );
    }

    protected Document newDocument( )
    {
        return new Document( PageSize.A4 );
    }

    protected PdfWriter newWriter( Document document, OutputStream os ) throws DocumentException
    {
        return PdfWriter.getInstance( document, os );
    }

    protected void prepareWriter(PdfWriter writer)
    {
        writer.setViewerPreferences( getViewerPreferences( ) );
    }

    protected int getViewerPreferences( )
    {
        return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
    }

    protected void buildPdfMetadata( Map<String, Object> model, Document document, HttpServletRequest request )
    {
    }

    protected abstract void buildPdfDocument( Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response ) throws dummyBusinessException,IOException;

    protected void addPagesNumbers( Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response, ByteArrayOutputStream baos ) throws dummyBusinessException,IOException, DocumentException
    {
    }
}
