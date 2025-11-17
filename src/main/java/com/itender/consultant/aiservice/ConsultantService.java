package com.itender.consultant.aiservice;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

/**
 * @author analytics
 * @date 2025/11/10 21:43
 * @description
 */

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        streamingChatModel = "openAiStreamingChatModel",
        // chatMemory = "chatMemory",
        chatMemoryProvider = "chatMemoryProvider",
        contentRetriever = "contentRetriever",  // 配置向量数据库检索对象
        tools = "reservationTool"
)
public interface ConsultantService {

    /**
     * 聊天,阻塞时调用
     * @param message
     * @return
     */
    // String chat(String message);

    /**
     * 聊天,流式输出
     *
     * @param message
     * @return
     */
    // @SystemMessage("你是伟哥的小助手小月月，人美心善又多金")
    @SystemMessage(fromResource = "system.txt")
    Flux<String> chat(@MemoryId String memoryId, @UserMessage String message);
}
