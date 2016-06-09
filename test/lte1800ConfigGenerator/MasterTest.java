package lte1800ConfigGenerator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ InputReaderTest.class, LteSiteTest.class, XmlCreatorTest.class, AllLteSitesTest.class,
		AllConfigFilesTest.class })

public class MasterTest {

}
