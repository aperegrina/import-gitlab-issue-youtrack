package com.main;


import org.certuit.google.spreadsheet.SpreadsheetAPI;
import org.certuit.google.spreadsheet.SpreadsheetIssue;
import org.certuit.utils.Transform;
import org.gitlab.api.GitlabAPI;
import org.gitlab.api.models.GitlabIssue;
import org.gitlab.api.models.GitlabProject;

import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) {

//        GitlabAPI gitlabAPIIgnoreSSL=GitlabAPI.connect("https://192.168.1.61/","XeNPD4sFisoVCfZU6XHR");
//        gitlabAPIIgnoreSSL.ignoreCertificateErrors(true);
//        GitlabProject project=new GitlabProject();
//        project.setId(60);
//        try {
//            List<GitlabIssue> listIssues=gitlabAPIIgnoreSSL.getIssues(project, null);
//            System.out.println("List of issues: "+listIssues.size());
//            Transform.GitlabIssueToXMLYoutrack(listIssues);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            List<SpreadsheetIssue> listIssues=SpreadsheetAPI.getSpreadsheetIssue("1zsfXG6js0EkT9q35m0Mm7AvsAjCfB-WGACgauPXckmY","Defectos build v1.8!A2:P");
            System.out.println("List of issues: "+listIssues.size());
            Transform.SpreadsheetIssueToXMLYoutrack(listIssues);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
