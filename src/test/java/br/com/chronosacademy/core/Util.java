package br.com.chronosacademy.core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Util {
    private static String nomeCenario;
    private static File diretorio;
    private static int numPrint;

    public static void setNomeCenario(String nomeCenario) {
        Util.nomeCenario = nomeCenario;
    }

    public static void criaDiretorio(){
        String caminho = "src/test/resources/evidencias";
        diretorio = new File(caminho + "/" + nomeCenario);
        diretorio.mkdir();
        numPrint = 0;
    }

    public static void printScreen(String step) throws Exception {
        numPrint++;
        File file = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String caminho = diretorio.getPath() + "/" + numPrint + "-" + step + ".png";
        try {
            FileUtils.copyFile(file, new File(caminho));
        } catch (IOException e) {
            throw new Exception("Houve uma falha ao criar o arquivo");
        }
    }

}
