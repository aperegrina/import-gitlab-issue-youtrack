package org.certuit.utils;

import org.certuit.google.spreadsheet.SpreadsheetIssue;
import org.gitlab.api.models.GitlabIssue;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * Created by andre on 5/15/16.
 */
public class Transform {

    public static String GitlabIssueToXMLYoutrack(List<GitlabIssue> responseList) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element issues = doc.createElement("issues");
            doc.appendChild(issues);

            for (GitlabIssue item : responseList
                    ) {
                // staff elements
                Element issue = doc.createElement("issue");
                issues.appendChild(issue);
                //Add to parent
                issue.appendChild(createFieldYoutrack(doc, "numberInProject", Integer.toString(item.getId())));
                issue.appendChild(createFieldYoutrack(doc, "summary", item.getTitle()));
                issue.appendChild(createFieldYoutrack(doc, "description", item.getDescription()));
                issue.appendChild(createFieldYoutrack(doc, "created", (item.getCreatedAt().getTime() / 1000) + ""));
                issue.appendChild(createFieldYoutrack(doc, "reporterName", item.getAuthor().getUsername()));
                if (item.getState().equals(GitlabIssue.STATE_CLOSED)) {
                    issue.appendChild(createFieldYoutrack(doc, "state", "fixed"));
                    issue.appendChild(createFieldYoutrack(doc, "resolved", (item.getUpdatedAt().getTime() / 1000) + ""));
                }
            }

            System.out.println(doc.toString());
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("out.xml"));

            // Output to console for testing
//            StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        return "";
    }

    public static String SpreadsheetIssueToXMLYoutrack(List<SpreadsheetIssue> responseList) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element issues = doc.createElement("issues");
            doc.appendChild(issues);

            for (SpreadsheetIssue item : responseList
                    ) {
                // staff elements
                Element issue = doc.createElement("issue");
                issues.appendChild(issue);
                //Add to parent
                issue.appendChild(createFieldYoutrack(doc, "numberInProject", Integer.toString(item.getId())));
                issue.appendChild(createFieldYoutrack(doc, "summary", item.getDescripcion()));
                issue.appendChild(createFieldYoutrack(doc, "description", item.getDescripcion()));
                issue.appendChild(createFieldYoutrack(doc, "created", (item.getFecha().getTime() / 1000) + ""));
                issue.appendChild(createFieldYoutrack(doc, "reporterName", item.getRegistrado()));
//                if (item.getState().equals(GitlabIssue.STATE_CLOSED)) {
//                    issue.appendChild(createFieldYoutrack(doc, "state", "fixed"));
//                    issue.appendChild(createFieldYoutrack(doc, "resolved", (item.getUpdatedAt().getTime() / 1000) + ""));
//                }
            }

            System.out.println(doc.toString());
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("out.xml"));

            // Output to console for testing
//            StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        return "";
    }

    private static Element createFieldYoutrack(Document doc, String nameString, String valueString) {
        // Init field
        Element field = doc.createElement("field");
        Attr attr = doc.createAttribute("name");
        attr.setValue(nameString);
        field.setAttributeNode(attr);
        //Init value of field
        Element value = doc.createElement("value");
        value.appendChild(doc.createTextNode(valueString));
        field.appendChild(value);
        return field;
    }
}
