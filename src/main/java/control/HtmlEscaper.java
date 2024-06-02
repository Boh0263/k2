package control;

public class HtmlEscaper {
	    public static String escapeHtml(String input) {
	        if (input == null) {
	            return null;
	        }
	        return input.replace("&", "&amp;")
	                    .replace("<", "&lt;")
	                    .replace(">", "&gt;")
	                    .replace("\"", "&quot;")
	                    .replace("'", "&#x27;")
	                    .replace("/", "&#x2F;");
	    }
	}


