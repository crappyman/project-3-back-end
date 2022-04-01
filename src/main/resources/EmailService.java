emailSender.setHost("smtp.gmail.com");
	    emailSender.setPort(587);
	    emailSender.setUsername("devdemoacct1@gmail.com");
	    emailSender.setPassword("Gmaildemo-1");
	    
	    Properties props = emailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.debug", "true");
	    props.put("mail.smtp.port","587");
        props.put("mail.smtp.host", "devdemoacct1@gmail.com");
        props.put("mail.smtp.starttls.enable", "true") ;
        props.put("mail.smtp.auth", "true") ;
emailSender.setJavaMailProperties(props);