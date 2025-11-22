package objectmapper;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class R03_JsonNode {


    public static void main(String[] args) throws JsonProcessingException {


        String jsondemo= """
                {
                  "id": 101,
                  "name": "Sumit",
                  "address": {
                    "city": "Pune",
                    "pincode": 411001,
                    "geo": {
                      "lat": 18.5204,
                      "lng": 73.8567
                    }
                  },
                  "skills": [
                    {
                      "name": "Java",
                      "experience": 5
                    },
                    {
                      "name": "Selenium",
                      "experience": 4
                    }
                  ],
                  "projects": [
                    {
                      "title": "Automation Framework",
                      "completed": true
                    },
                    {
                      "title": "Pricing Engine",
                      "completed": false
                    }
                  ],
                  "active": true
                }
                
                """;


        //Reading json into jsonNode using ObjectMapper
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode=objectMapper.readTree(jsondemo);


        // external  keys
        int id=jsonNode.get("id").asInt();
        System.out.println(id);//101

        String name = jsonNode.get("name").asText();
        boolean active = jsonNode.get("active").asBoolean();


        // Nested Objects
        JsonNode addressNode=jsonNode.get("address");

        String city = addressNode.get("city").asText();
        int pincode = addressNode.get("pincode").asInt();

        System.out.println(city);    // Pune
        System.out.println(pincode); // 411001


//        Step 4: Extract Deep Nested Object
//        address → geo → lat/lng
        JsonNode geoNode = jsonNode.get("address").get("geo");

        double lat = geoNode.get("lat").asDouble();
        double lng = geoNode.get("lng").asDouble();

        System.out.println(lat);  // 18.5204
        System.out.println(lng);  // 73.8567


        //Step 5: Extract Array → skills
        JsonNode skillsArray = jsonNode.get("skills");
        for(JsonNode skill : skillsArray) {
            String skillName = skill.get("name").asText();
            int exp = skill.get("experience").asInt();
            System.out.println(skillName + " -> " + exp);
        }


//
//        Step 7: Modify the JsonNode
//        Add new field
                ((ObjectNode) jsonNode).put("role", "QA Engineer");

       // Modify existing field
                ((ObjectNode) jsonNode.get("address")).put("city", "Mumbai");

        //Add a new skill
        ObjectNode newSkill = objectMapper.createObjectNode();
        newSkill.put("name", "DevOps");
        newSkill.put("experience", 2);

        ((ArrayNode) jsonNode.get("skills")).add(newSkill);

//⭐ //Step 8: Convert back to JSON String
        String updatedJson = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonNode);

        System.out.println(updatedJson);

//⭐// Step 9: Convert any JsonNode → POJO
//        User u = mapper.treeToValue(root, User.class);
//
//
//        Or convert nested node:
//
//        CityGeo geo = mapper.treeToValue(root.get("address").get("geo"), CityGeo.class);

    }
}
