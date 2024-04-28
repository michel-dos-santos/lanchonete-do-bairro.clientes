package br.com.lanchonete;

import br.com.lanchonete.model.LogCode;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
@ExtendWith(MockitoExtension.class)
public class Log4jRepositoryTests {

    @InjectMocks
    private Log4jRepository log4jRepository;
    private static EasyRandom easyRandom;

    @BeforeAll
    public static void beforeTests() {
        easyRandom = new EasyRandom();
    }

    @Test
    public void debugTest(CapturedOutput output) throws Exception {
        String loggers = String.format("TAG: _0001 - MESSAGE: %s", LogCode.LogCodeDebug._0001.getDescription());
        log4jRepository.debug(Log4jRepositoryTests.class, LogCode.LogCodeDebug._0001);

        assertThat(output).contains(loggers);
    }

    @Test
    public void infoTest(CapturedOutput output) throws Exception {
        String loggers = String.format("TAG: _0001 - MESSAGE: %s", LogCode.LogCodeInfo._0001.getDescription());
        log4jRepository.info(Log4jRepositoryTests.class, LogCode.LogCodeInfo._0001);

        assertThat(output).contains(loggers);
    }

    @Test
    public void warnTest(CapturedOutput output) throws Exception {
        String loggers = String.format("TAG: _0001 - MESSAGE: %s", LogCode.LogCodeWarn._0001.getDescription());
        log4jRepository.warn(Log4jRepositoryTests.class, LogCode.LogCodeWarn._0001);

        assertThat(output).contains(loggers);
    }

    @Test
    public void errorTest(CapturedOutput output) throws Exception {
        String loggers = String.format("TAG: _0001 - MESSAGE: %s", LogCode.LogCodeError._0001.getDescription());
        log4jRepository.error(Log4jRepositoryTests.class, LogCode.LogCodeError._0001);

        assertThat(output).contains(loggers);
    }

}


