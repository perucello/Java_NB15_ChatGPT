package nb15_chatgpt;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import java.util.List;

/*
    jar   - https://jar-download.com/artifacts/com.theokanning.openai-gpt3-java
    jar documentacao - https://jar-download.com/artifacts/com.theokanning.openai-gpt3-java/service/0.10.0/documentation
    jar download - https://jar-download.com/download-handling.php
    
    
    maven - https://mvnrepository.com/artifact/com.theokanning.openai-gpt3-java
            https://central.sonatype.com/?smo=true
            https://github.com/TheoKanning/openai-java
            
 	<dependency>
			<groupId>com.theokanning.openai-gpt3-java</groupId>
			<artifactId>client</artifactId>
			<version>0.9.0</version>       
		</dependency>
		
		library - https://platform.openai.com/docs/libraries/community-libraries
		documentação model - https://platform.openai.com/docs/models/gpt-3
		gerar token: https://platform.openai.com/account/api-keys
		
 */
public class NB15_ChatGPT {

    private static final String token_Generate = "sk-";
    public static final String question = "O que é linguagem de programação Java ?";

    public static void chamada_chatGPT(String token_Generate, String question) {

        System.out.println("Usando Netbeans15");
        System.out.println("**** Testando ChatGPT - EducaCiencia FastCode 27/02/2023 **** ");

        OpenAiService service_ChatGPT = new OpenAiService(token_Generate);

        CompletionRequest request_GPT = CompletionRequest.builder()
                .model("text-davinci-003") // model  -> documentação https://platform.openai.com/docs/models/gpt-3
                .prompt(question) //pergunta ao chatGPT
                .maxTokens(500) // caracteres
                .temperature(0.0) //recebe double , nesse caso deixamos 0.0 para nao variar resposta
                .build();

        List<CompletionChoice> resposta = service_ChatGPT.createCompletion(request_GPT).getChoices();

        System.out.println("Pergunta: " + question + "\n\n " + resposta);

    }

    public static void main(String[] args) {

        chamada_chatGPT(token_Generate, question);

    }

}
