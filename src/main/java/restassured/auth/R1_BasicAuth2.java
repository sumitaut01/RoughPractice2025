package restassured.auth;

import io.restassured.RestAssured;
import io.restassured.response.Response;

//https://the-internet.herokuapp.com/basic_auth
//admin/admin
public class R1_BasicAuth2 {
    public static void main(String[] args) {
        Response response= RestAssured.given().auth().basic("admin", "admin")
                .baseUri("https://the-internet.herokuapp.com")
                .basePath("/basic_auth")
                .get();
        System.out.println(response.then().log().all());

        //HTTP/1.1 200 OK
        //Content-Length: 1643
        //Content-Type: text/html;charset=utf-8
        //Date: Wed, 20 Aug 2025 04:21:30 GMT
        //Nel: {"report_to":"heroku-nel","response_headers":["Via"],"max_age":3600,"success_fraction":0.01,"failure_fraction":0.1}
        //Report-To: {"group":"heroku-nel","endpoints":[{"url":"https://nel.heroku.com/reports?s=bQGUmdEAA%2FfT4yfC6G%2BmZqlvLDGcYqJv9FEc%2F6Yf0gE%3D\u0026sid=c46efe9b-d3d2-4a0c-8c76-bfafa16c5add\u0026ts=1755663690"}],"max_age":3600}
        //Reporting-Endpoints: heroku-nel="https://nel.heroku.com/reports?s=bQGUmdEAA%2FfT4yfC6G%2BmZqlvLDGcYqJv9FEc%2F6Yf0gE%3D&sid=c46efe9b-d3d2-4a0c-8c76-bfafa16c5add&ts=1755663690"
        //Server: Heroku
        //Set-Cookie: rack.session=BAh7CUkiD3Nlc3Npb25faWQGOgZFVEkiRTJjNGI4ZDlkNWU3NDQxODI0Y2Y3%0AZDgwOGZkNDVhNWI3M2FkNTI0MTJjMDdhNjkwYjY0ODA0NWZlNjIxMjk1Y2QG%0AOwBGSSIJY3NyZgY7AEZJIiVjYTRhZTM2MWE2NjcyNzk0NTQwZWViYmM1NDIy%0ANmU0YgY7AEZJIg10cmFja2luZwY7AEZ7B0kiFEhUVFBfVVNFUl9BR0VOVAY7%0AAFRJIi0yNDMzOTNkMWNlMmUxMzhjZGZjNjI3YjI3MjZlMzRhNTM4OGM3OGMw%0ABjsARkkiGUhUVFBfQUNDRVBUX0xBTkdVQUdFBjsAVEkiLWRhMzlhM2VlNWU2%0AYjRiMGQzMjU1YmZlZjk1NjAxODkwYWZkODA3MDkGOwBGSSIKZmxhc2gGOwBG%0AewA%3D%0A--efdcc3b57efdc0919cf37f8dc958d0d69a455f33; path=/; HttpOnly
        //Via: 1.1 heroku-router
        //X-Content-Type-Options: nosniff
        //X-Frame-Options: SAMEORIGIN
        //X-Xss-Protection: 1; mode=block
        //
        //<html class="no-js" lang="en">
        //  <html>
        //    <head>
        //      <script src="/js/vendor/298279967.js"/>
        //      <meta charset="utf-8"/>
        //      <meta name="viewport" content="width=device-width"/>
        //      <title>The Internet</title>
        //      <link href="/css/app.css" rel="stylesheet"/>
        //      <link href="/css/font-awesome.css" rel="stylesheet"/>
        //      <script src="/js/vendor/jquery-1.11.3.min.js"/>
        //      <script src="/js/vendor/jquery-ui-1.11.4/jquery-ui.js"/>
        //      <script src="/js/foundation/foundation.js"/>
        //      <script src="/js/foundation/foundation.alerts.js"/>
        //      <script>
        //      $(document).foundation();
        //    </script>
        //    </head>
        //    <body>
        //      <div class="row">
        //        <div class="large-12 columns" id="flash-messages"/>
        //      </div>
        //      <div class="row">
        //        <a shape="rect" href="https://github.com/tourdedave/the-internet">
        //          <img style="position: absolute; top: 0; right: 0; border: 0;" src="/img/forkme_right_green_007200.png" alt="Fork me on GitHub"/>
        //        </a>
        //        <div class="large-12 columns" id="content">
        //          <div class="example">
        //            <h3>Basic Auth</h3>
        //            <p>
        //    Congratulations! You must have the proper credentials.
        //  </p>
        //          </div>
        //        </div>
        //      </div>
        //      <div class="row" id="page-footer">
        //        <div class="large-4 large-centered columns">
        //          <hr/>
        //          <div style="text-align: center;">
        //Powered by             <a shape="rect" target="_blank" href="http://elementalselenium.com/">Elemental Selenium</a>
        //          </div>
        //        </div>
        //      </div>
        //    </body>
        //  </html>
        //</html>
        //io.restassured.internal.ValidatableResponseImpl@604b1e1d

    }
}
