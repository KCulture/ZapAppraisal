package com.github.KCulture.ZapAppraisal.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;


@Service("QuestionReadService")
public class QuestionReadService {
	
	public List<String> getQuestions() {
		Path questionFile;
		List<String> questions = null;
		try{
			questionFile = Paths.get(this.getClass().getResource("config.properties").toURI());
			questions =	Files.readAllLines(questionFile, Charset.defaultCharset());
			return questions;
		}catch(URISyntaxException | IOException e){
			System.out.print(e.getLocalizedMessage());
		}
		return questions;
		
	}
}
