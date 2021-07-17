package com.project;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.project.dao.OutputRepository;
import com.project.dao.UserRepository;
import com.project.dao.UserService;
import com.project.entities.Output;
import com.project.entities.input_details;

@SpringBootApplication
public class SpringAppProjectApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringAppProjectApplication.class);
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringAppProjectApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		OutputRepository outputRepository = context.getBean(OutputRepository.class);

		Map<String,String> mp=new HashMap<String,String>();
		UserService ms = context.getBean(UserService.class);
				List<input_details> allUser = userRepository.getData();
				
				allUser.forEach(e->{
String add = ms.getFinalData(e.getInput_string());
					//System.out.println(e.getInput_string());
LOGGER.info("INput String"+e.getInput_string()+"Output String"+add);

					mp.put(e.getInput_string(), add);
				});
			
				 Iterator<Map.Entry<String, String>> itr = mp.entrySet().iterator();
		         List<Output> lst=new ArrayList<Output>();
		         Output opt=null;
			        while(itr.hasNext())
			        {
			        	opt=new Output();
			             Map.Entry<String, String> entry = itr.next();
			             LOGGER.info("Output String " + entry.getKey() +
			                                 ",-->> Total Count taken to iterate = " + entry.getValue());
			             opt.setOutput(entry.getValue().split("\\-")[0]);
			             opt.setCount(Integer.valueOf(entry.getValue().split("\\-")[1]));
			             opt.setName("Kailash");
			             opt.setPublishedOn(parseTimestamp("2021-07-17 20:51:00"));
			             outputRepository.save(opt);
                        lst.add(opt) ;
			             
			        }
				
				}
				

			

	private static java.sql.Timestamp parseTimestamp(String timestamp) {
	    try {
	    	final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	        return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}
}
