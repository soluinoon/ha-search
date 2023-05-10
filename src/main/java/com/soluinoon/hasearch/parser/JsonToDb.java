package com.soluinoon.hasearch.parser;

import java.io.IOException;

public class JsonToDb {
    public void parseChampion() throws IOException {
//        // JPA 설정
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        // JSON 파일을 읽어들일 폴더 경로
//        String folderPath = "C:/json_files";
//        Resource resource = new ClassPathResource("dragontail-13.6.1/13.6.1/data/ko_KR/champion");
//        // 폴더 내의 파일 목록을 가져옴
//        File folder = resource.getFile();
//        File[] fileList = folder.listFiles();
//
//        // 파일 목록을 반복하여 JSON 파일을 읽어들임
//        for (File file : fileList) {
//            if (file.isFile() && file.getName().endsWith(".json")) {
//                try {
//                    // JSON 파일 읽기
//                    JsonReader jsonReader = Json.createReader(new FileReader(file));
//                    JsonObject jsonObject = jsonReader.readObject();
//
//                    // 데이터 저장
//                    Champion champion = new Champion();
//                    champion.setId((long)(jsonObject.getInt("key"))); // "key"를 "id"로 저장
//                    champion.setName(jsonObject.getString("name"));
//                    champion.setImagePath(jsonObject.getString(""));
//                    champion.setField3(jsonObject.getBoolean("field3"));
//                    entityManager.getTransaction().begin();
//                    entityManager.persist(myEntity);
//                    entityManager.getTransaction().commit();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        // 연결 종료
//        entityManager.close();
//        entityManagerFactory.close();
//    }
//    }
    }
}