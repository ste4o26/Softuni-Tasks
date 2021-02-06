package softuni.library.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {
    <O> O fromXml(String filePath ,Class<O> clazz) throws JAXBException;
}
