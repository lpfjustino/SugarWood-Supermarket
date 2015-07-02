//package sugarwood.supermarket.network;
//public class MailSender {
//    public void sendMail() {
//        try{
//            costumersList = ms.registeredCostumersList();
//
//            Properties props = new Properties();
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.starttls.enable", "true");
//            props.put("mail.smtp.host", "smtp.gmail.com");
//            props.put("mail.smtp.port", "587");
//            //Recebe dados do email a ser enviado
//            Session session = Session.getInstance(props,
//                              new javax.mail.Authenticator() {
//                                    protected PasswordAuthentication getPasswordAuthentication() {
//                                            return new PasswordAuthentication("testetrabpoo@gmail.com", "testetrabpoo123");
//                                    }
//                              });
//            //envia email para todos os usuarios
//            for(Costumer c : costumersList)
//            {
//                    Message msg = new MimeMessage(session);
//            msg.setFrom(new InternetAddress("testetrabpoo@gmail.com"));
//            msg.addRecipient(Message.RecipientType.TO,
//                             new InternetAddress(c.getEmail()));
//            msg.setSubject("New products avaiable");
//            msg.setText(msgBody);
//            Transport.send(msg);
//            System.out.println("Email enviado");
//            }
//        }
//        catch(Exception e)
//        {
//            System.out.println("Erro");
//        }
//    }
//    
//    public void sendEmail(String destinyEmail, String itemUpdated){
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", true);
//        props.put("mail.smtp.starttls.enable", true);
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        Session session = Session.getDefaultInstance(props, new Authenticator(){
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication(){
//                return new PasswordAuthentication("t4poo2015@gmail.com", "t4poo1234");
//            }
//        });
//
//        String msgBody = "The product: \n\n-->  "+ itemUpdated +
//                " <--\nhas been updated!\n\n"
//                + "Carro&4 Supermarket.";
//
//        try {
//            Message msg = new MimeMessage(session);
//            msg.setFrom(new InternetAddress("t4poo2015@gmail.com"));
//            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinyEmail));
//            msg.setSubject("Carro&4: Item updated!");
//            msg.setText(msgBody);
//            Transport.send(msg);
//
//        } catch (AddressException e) {
//        } catch (MessagingException e) {
//        }
//    }
//}
