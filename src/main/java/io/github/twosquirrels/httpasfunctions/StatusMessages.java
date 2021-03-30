package io.github.twosquirrels.httpasfunctions;

import java.util.HashMap;

/**
 * HashMap extension class to get the meaning of the response from the HTTP status code
 * @author TwoSquirrels
 * @version 1.2.2
 */
public class StatusMessages extends HashMap<Integer, String> {
    
    private static final long serialVersionUID = 1L;
    
    private void setStatusAll(boolean errorOnly) {
        if (!errorOnly) {
            // 1xx Informational
            super.put(100, "Continue");
            super.put(101, "Switching Protocols");
            super.put(102, "Processing");
            super.put(103, "Early Hints");
            // 2xx Success
            super.put(200, "OK");
            super.put(201, "Created");
            super.put(202, "Accepted");
            super.put(203, "Non-Authoritative Information");
            super.put(204, "No Content");
            super.put(205, "Reset Content");
            super.put(206, "Partial Content");
            super.put(207, "Multi-Status");
            super.put(208, "Already Reported");
            super.put(226, "IM Used");
            // 3xx Redirection
            super.put(300, "Multiple Choices");
            super.put(301, "Moved Permanently");
            super.put(302, "Found");
            super.put(303, "See Other");
            super.put(304, "Not Modified");
            super.put(305, "Use Proxy");
            super.put(306, "(Unused)");   // unused
            super.put(307, "Temporary Redirect");
            super.put(308, "Permanent Redirect");
        }
        // 4xx Client Error
        super.put(400, "Bad Request");
        super.put(401, "Unauthorized");
        super.put(402, "Payment Required");
        super.put(403, "Forbidden");
        super.put(404, "Not Found");
        super.put(405, "Method Not Allowed");
        super.put(406, "Not Acceptable");
        super.put(407, "Proxy Authentication Required");
        super.put(408, "Request Timeout");
        super.put(409, "Conflict");
        super.put(410, "Gone");
        super.put(411, "Length Required");
        super.put(412, "Precondition Failed");
        super.put(413, "Payload Too Large");
        super.put(414, "URI Too Long");
        super.put(415, "Unsupported Media Type");
        super.put(416, "Range Not Satisfiable");
        super.put(417, "Expectation Failed");
        super.put(418, "I'm a teapot");   // joke code
        super.put(421, "Misdirected Request");
        super.put(422, "Unprocessable Entity");
        super.put(423, "Locked");
        super.put(424, "Failed Dependency");
        super.put(425, "Too Early");
        super.put(426, "Upgrade Required");
        super.put(428, "Precondition Required");
        super.put(429, "Too Many Requests");
        super.put(431, "Request Header Fields Too Large");
        super.put(451, "Unavailable For Legal Reasons");
        // 5xx Server Error
        super.put(500, "Internal Server Error");
        super.put(501, "Not Implemented");
        super.put(502, "Bad Gateway");
        super.put(503, "Service Unavailable");
        super.put(504, "Gateway Timeout");
        super.put(505, "HTTP Version Not Supported");
        super.put(506, "Variant Also Negotiates");
        super.put(507, "Insufficient Storage");
        super.put(508, "Loop Detected");
        super.put(510, "Not Extended");
        super.put(511, "Network Authentication Required");
    }

    public StatusMessages() {
        this.setStatusAll(false);
    }

    public StatusMessages(boolean errorOnly) {
        this.setStatusAll(errorOnly);
    }

}
