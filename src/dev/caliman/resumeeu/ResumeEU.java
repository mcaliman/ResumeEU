package dev.caliman.resumeeu;

import eu.europa.cedefop.europass.europass.AttachmentListType;
import eu.europa.cedefop.europass.europass.AttachmentType;
import eu.europa.cedefop.europass.europass.CoverLetterType;
import eu.europa.cedefop.europass.europass.DocumentInfoType;
import eu.europa.cedefop.europass.europass.PrintingPreferencesType;
import eu.europa.cedefop.europass.europass.SkillsPassport;
import java.io.File;
import java.util.List;

import java.util.logging.Logger;
import java.util.logging.Level;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Massimo Caliman
 */
public class ResumeEU {

    private static final Logger LOG = Logger.getLogger(ResumeEU.class.getName());

    public ResumeEU() {
    }

    public void execute() {
        JAXBContext jaxbContext;
        try {
            File xmlFile = new File("CV-Europass-20171023-Caliman-IT.xml");
            jaxbContext = JAXBContext.newInstance(SkillsPassport.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            SkillsPassport skillsPassport = (SkillsPassport) jaxbUnmarshaller.unmarshal(xmlFile);
            execute(skillsPassport);
            System.out.println(skillsPassport);
        } catch (JAXBException e) {
            LOG.log(Level.SEVERE, "", e);
        }

    }

    private void execute(SkillsPassport sp) {
        AttachmentListType al = sp.getAttachmentList();
        execute(al);
        CoverLetterType cl = sp.getCoverLetter();
        execute(cl);
        DocumentInfoType di = sp.getDocumentInfo();
        execute(di);
        String locale = sp.getLocale();
        PrintingPreferencesType pr = sp.getPrintingPreferences();
        System.out.println("");
    }

    private void execute(AttachmentListType al) {
        if (al == null) {
            return;
        }
        List<AttachmentType> attachments = al.getAttachment();
        //TODO
    }

    private void execute(CoverLetterType cl) {
        if (cl == null) {
            return;
        }
        //TODO
    }

    private void execute(DocumentInfoType di) {
        if (di == null) {
            return;
        }
        di.getBundle();
        di.getComment();
        di.getCopyright();
        di.getCreationDate();
        di.getDocumentType();
        di.getGenerator();
        di.getLastUpdateDate();
        di.getXSDVersion();

    }

    public static void main(
            String[] args) {
        ResumeEU command = new ResumeEU();
        command.execute();
    }

}
