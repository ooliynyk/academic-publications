package vntu.academcoop.utils.crawling;

import org.jsoup.nodes.Document;

public interface DocumentParser {

	Document parseDocument(String url) throws DocumentParsingException;

}
