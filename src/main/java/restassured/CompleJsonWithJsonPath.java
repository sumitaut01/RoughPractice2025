package restassured;

import io.restassured.path.json.JsonPath;

public class CompleJsonWithJsonPath {


    public static void main(String[] args) {
        String complex= """
                {
                  "userProfile": {
                    "userId": "usr_123456",
                    "username": "coder_guru",
                    "email": "coder.guru@example.com",
                    "isVerified": true,
                    "lastLogin": "2025-09-19T21:29:53Z",
                    "preferences": {
                      "theme": "dark",
                      "notifications": {
                        "email": true,
                        "push": false,
                        "sms": false
                      },
                      "language": "en-US"
                    },
                    "location": {
                      "city": "San Francisco",
                      "country": "USA",
                      "coordinates": {
                        "latitude": 37.7749,
                        "longitude": -122.4194
                      }
                    }
                  },
                  "recentActivity": [
                    {
                      "activityId": "act_987654",
                      "type": "post_creation",
                      "timestamp": "2025-09-19T20:50:00Z",
                      "details": {
                        "postId": "pst_112233",
                        "title": "Introduction to Complex JSON",
                        "tags": ["JSON", "data-structures", "web-dev"],
                        "views": 150
                      }
                    },
                    {
                      "activityId": "act_654321",
                      "type": "comment_submission",
                      "timestamp": "2025-09-19T21:10:15Z",
                      "details": {
                        "commentId": "cmt_445566",
                        "postId": "pst_112233",
                        "commentText": "This is a great example!",
                        "authorId": "usr_998877"
                      }
                    }
                  ],
                  "projects": [
                    {
                      "projectId": "proj_101",
                      "projectName": "API Gateway",
                      "status": "in-progress",
                      "teamMembers": [
                        {
                          "memberId": "dev_001",
                          "name": "Alice Johnson",
                          "role": "Lead Developer"
                        },
                        {
                          "memberId": "dev_002",
                          "name": "Bob Williams",
                          "role": "Backend Developer"
                        }
                      ],
                      "milestones": [
                        {
                          "milestoneId": "ms_01",
                          "name": "Initial Design",
                          "dueDate": "2025-10-15",
                          "completed": true
                        },
                        {
                          "milestoneId": "ms_02",
                          "name": "Beta Release",
                          "dueDate": "2025-12-01",
                          "completed": false
                        }
                      ]
                    },
                    {
                      "projectId": "proj_102",
                      "projectName": "Data Analytics Dashboard",
                      "status": "completed",
                      "teamMembers": [
                        {
                          "memberId": "dev_003",
                          "name": "Charlie Brown",
                          "role": "Data Scientist"
                        }
                      ],
                      "milestones": [
                        {
                          "milestoneId": "ms_03",
                          "name": "Data Integration",
                          "dueDate": "2025-08-20",
                          "completed": true
                        }
                      ]
                    }
                  ],
                  "isDeletable": false,
                  "lastUpdatedBy": "admin_user"
                }
                """;


        JsonPath jsonPath=new JsonPath(complex);

        System.out.println(jsonPath.getString("userProfile.userId"));//usr_123456
        System.out.println(jsonPath.getString("userProfile.preferences.theme"));//dark

        System.out.println(jsonPath.getList("projects"));//[{projectId=proj_101, projectName=API Gateway, status=in-progress, teamMembers=[{memberId=dev_001, name=Alice Johnson, role=Lead Developer}, {memberId=dev_002, name=Bob Williams, role=Backend Developer}], milestones=[{milestoneId=ms_01, name=Initial Design, dueDate=2025-10-15, completed=true}, {milestoneId=ms_02, name=Beta Release, dueDate=2025-12-01, completed=false}]}, {projectId=proj_102, projectName=Data Analytics Dashboard, status=completed, teamMembers=[{memberId=dev_003, name=Charlie Brown, role=Data Scientist}], milestones=[{milestoneId=ms_03, name=Data Integration, dueDate=2025-08-20, completed=true}]}]
        System.out.println(jsonPath.getString("projects[0]"));//[projectId:proj_101, projectName:API Gateway, status:in-progress, teamMembers:[[memberId:dev_001, name:Alice Johnson, role:Lead Developer], [memberId:dev_002, name:Bob Williams, role:Backend Developer]], milestones:[[milestoneId:ms_01, name:Initial Design, dueDate:2025-10-15, completed:true], [milestoneId:ms_02, name:Beta Release, dueDate:2025-12-01, completed:false]]]
        System.out.println(jsonPath.getString("projects[0].teamMembers"));//[[memberId:dev_001, name:Alice Johnson, role:Lead Developer], [memberId:dev_002, name:Bob Williams, role:Backend Developer]]


//        Response response=RestAssured.given()
//                .baseUri("").basePath("")
//                .header("","").contentType(ContentType.JSON).auth().oauth2("")
//                .body("string").post();
//        System.out.println(response.jsonPath());
//        System.out.println(response.asString());
    }
}
