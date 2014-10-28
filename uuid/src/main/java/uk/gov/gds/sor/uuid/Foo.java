package uk.gov.gds.sor.uuid;

import static spark.Spark.get;

class Server {
    public static void main(String[] args) {
        get("/foo", (request, response) -> "Foo");
    }
}
