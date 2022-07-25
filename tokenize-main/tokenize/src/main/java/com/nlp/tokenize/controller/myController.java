package com.nlp.tokenize.controller;

import java.util.List;
import java.util.function.IntPredicate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@RestController
@RequestMapping("/nlp")
public class myController {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	static
	String userinfo; 
	String action;
	String memberID;
	String lemma;
	
	@Autowired
	private StanfordCoreNLP stanfordcorenlp;
	
	@PostMapping("/nlp/tokenize")
	public List<String> str(@RequestBody final String input){
		
		CoreDocument coreDocument = new CoreDocument(input);
		stanfordcorenlp.annotate(coreDocument);
		List<CoreLabel> coreLabels = coreDocument.tokens();
		
		for(CoreLabel coreLabel : coreLabels) {
		
			String pos = coreLabel.getString(CoreAnnotations.PartOfSpeechAnnotation.class);
			String lemma = coreLabel.lemma();
			System.out.println(coreLabel.originalText());
			if(pos=="NNP")//NNP = proper noun 
			{
				userinfo = coreLabel.originalText();
			}
			if(lemma == "appointment")
			{
				
				action = lemma; 
			}
				
		}
		
		memberID = userinfo;
		
		System.out.println("Output: " + lemma + memberID);
		return null;
	}


	public static String getUser() {
		// TODO Auto-generated method stub
		return userinfo;
	}

	

}
