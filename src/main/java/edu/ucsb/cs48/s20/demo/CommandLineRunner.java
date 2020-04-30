package edu.ucsb.cs48.s20.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.ucsb.cs48.s20.demo.entities.County;
import edu.ucsb.cs48.s20.demo.repositories.CountyRepository;
import edu.ucsb.cs48.s20.demo.services.CSVToObjectService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.io.InputStreamReader;


import org.slf4j.Logger;

@Component
public class CommandLineRunner implements ApplicationRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
	
	@Autowired
	private CountyRepository countyRepository;

	@Autowired
	CSVToObjectService<County> csvToObjectService;
	
	
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("hello world");
		if (args.containsOption("filename")) {
			loadDataFromFiles(args.getOptionValues("filename"));
		}
	}
	
	public void loadDataFromFiles(List<String> filenames) {
        for (var filename : filenames) {
            loadDataFromFile(filename);
        }
    }
	
	public void loadDataFromFile(String filename) {
        logger.warn("Loading data from {}", filename);

        InputStream targetStream = null;

        try {
            File initialFile = new File(filename);
            targetStream = new FileInputStream(initialFile);
        } catch (FileNotFoundException fnfe) {
            logger.error("File not found: {}, no data loaded.", filename);
            return;
        }

        try (Reader reader = new InputStreamReader(targetStream)) {
            List<County> counties = csvToObjectService.parse(reader, County.class);
            
            for(County c : counties) {
            	logger.info("County : {}",c);
            }
            
            countyRepository.saveAll(counties);
        } catch (IOException ioe) {
            logger.error("Exception: ", ioe);
        }

    }

}