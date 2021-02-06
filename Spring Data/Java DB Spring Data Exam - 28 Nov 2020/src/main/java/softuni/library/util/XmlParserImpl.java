package softuni.library.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class XmlParserImpl implements XmlParser {
    @Override
    @SuppressWarnings("unchecked")
    public <O> O fromXml(String filePath, Class<O> clazz) throws JAXBException {
        return (O) JAXBContext
                .newInstance(clazz)
                .createUnmarshaller()
                .unmarshal(new File(filePath));
    }
}
