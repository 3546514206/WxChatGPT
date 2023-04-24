package edu.zjnu.chatGpt.core;

import edu.zjnu.chatGpt.entity.billing.BillingUsage;
import edu.zjnu.chatGpt.entity.billing.CreditGrantsResponse;
import edu.zjnu.chatGpt.entity.billing.Subscription;
import edu.zjnu.chatGpt.entity.chat.ChatCompletion;
import edu.zjnu.chatGpt.entity.chat.ChatCompletionResponse;
import edu.zjnu.chatGpt.entity.common.DeleteResponse;
import edu.zjnu.chatGpt.entity.common.OpenAiResponse;
import edu.zjnu.chatGpt.entity.completions.Completion;
import edu.zjnu.chatGpt.entity.completions.CompletionResponse;
import edu.zjnu.chatGpt.entity.edits.Edit;
import edu.zjnu.chatGpt.entity.edits.EditResponse;
import edu.zjnu.chatGpt.entity.embeddings.Embedding;
import edu.zjnu.chatGpt.entity.embeddings.EmbeddingResponse;
import edu.zjnu.chatGpt.entity.engines.Engine;
import edu.zjnu.chatGpt.entity.files.File;
import edu.zjnu.chatGpt.entity.files.UploadFileResponse;
import edu.zjnu.chatGpt.entity.fineTune.Event;
import edu.zjnu.chatGpt.entity.fineTune.FineTune;
import edu.zjnu.chatGpt.entity.fineTune.FineTuneDeleteResponse;
import edu.zjnu.chatGpt.entity.fineTune.FineTuneResponse;
import edu.zjnu.chatGpt.entity.images.Image;
import edu.zjnu.chatGpt.entity.images.ImageResponse;
import edu.zjnu.chatGpt.entity.models.Model;
import edu.zjnu.chatGpt.entity.models.ModelResponse;
import edu.zjnu.chatGpt.entity.moderations.Moderation;
import edu.zjnu.chatGpt.entity.moderations.ModerationResponse;
import edu.zjnu.chatGpt.entity.whisper.WhisperResponse;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.*;

import java.time.LocalDate;
import java.util.Map;

/**
 * 描述： open ai官方api接口
 *
 * @author https:www.unfbx.com
 * 2023-02-15
 */
public interface OpenAiApi {

    /**
     * 模型列表
     *
     * @return Single ModelResponse
     */
    @GET("v1/models")
    Single<ModelResponse> models();

    /**
     * models 返回的数据id
     *
     * @param id
     * @return Single Model
     */
    @GET("v1/models/{id}")
    Single<Model> model(@Path("id") String id);

    /**
     * 文本问答
     * Given a prompt, the model will return one or more predicted completions, and can also return the probabilities of alternative tokens at each position.
     *
     * @param completion
     * @return Single CompletionResponse
     */
    @POST("v1/completions")
    Single<CompletionResponse> completions(@Body Completion completion);

    /**
     * Creates a new edit for the provided input, instruction, and parameters.
     * 文本修复
     *
     * @param edit
     * @return Single EditResponse
     */
    @POST("v1/edits")
    Single<EditResponse> edits(@Body Edit edit);

    /**
     * Creates an image given a prompt.
     * 根据描述生成图片
     *
     * @param image
     * @return Single ImageResponse
     */
    @POST("v1/images/generations")
    Single<ImageResponse> genImages(@Body Image image);

    /**
     * Creates an edited or extended image given an original image and a prompt.
     * 根据描述修改图片
     *
     * @param image
     * @param mask
     * @param requestBodyMap
     * @return Single ImageResponse
     */
    @Multipart
    @POST("v1/images/edits")
    Single<ImageResponse> editImages(@Part() MultipartBody.Part image,
                                     @Part() MultipartBody.Part mask,
                                     @PartMap() Map<String, RequestBody> requestBodyMap
    );

    /**
     * Creates a variation of a given image.
     *
     * @param image
     * @param requestBodyMap
     * @return Single ImageResponse
     */
    @Multipart
    @POST("v1/images/variations")
    Single<ImageResponse> variationsImages(@Part() MultipartBody.Part image,
                                           @PartMap() Map<String, RequestBody> requestBodyMap
    );

    /**
     * 文本向量计算
     *
     * @param embedding
     * @return Single EmbeddingResponse
     */
    @POST("v1/embeddings")
    Single<EmbeddingResponse> embeddings(@Body Embedding embedding);


    /**
     * Returns a list of files that belong to the user's organization.
     *
     * @return Single OpenAiResponse File
     */
    @GET("/v1/files")
    Single<OpenAiResponse<File>> files();

    /**
     * 删除文件
     *
     * @param fileId
     * @return Single DeleteResponse
     */
    @DELETE("v1/files/{file_id}")
    Single<DeleteResponse> deleteFile(@Path("file_id") String fileId);

    /**
     * 上传文件
     *
     * @param purpose
     * @param file
     * @return Single UploadFileResponse
     */
    @Multipart
    @POST("v1/files")
    Single<UploadFileResponse> uploadFile(@Part MultipartBody.Part file,
                                          @Part("purpose") RequestBody purpose);


    /**
     * 检索文件
     *
     * @param fileId
     * @return Single File
     */
    @GET("v1/files/{file_id}")
    Single<File> retrieveFile(@Path("file_id") String fileId);

    /**
     * 检索文件内容
     * ###不对免费用户开放###
     * ###不对免费用户开放###
     * ###不对免费用户开放###
     *
     * @param fileId
     * @return Single ResponseBody
     */
    @Streaming
    @GET("v1/files/{file_id}/content")
    Single<ResponseBody> retrieveFileContent(@Path("file_id") String fileId);


    /**
     * 文本审核
     *
     * @param moderation
     * @return Single ModerationResponse
     */
    @POST("v1/moderations")
    Single<ModerationResponse> moderations(@Body Moderation moderation);


    /**
     * 创建微调作业
     *
     * @param fineTune
     * @return Single FineTuneResponse
     */
    @POST("v1/fine-tunes")
    Single<FineTuneResponse> fineTune(@Body FineTune fineTune);

    /**
     * 微调作业集合
     *
     * @return Single OpenAiResponse FineTuneResponse
     */
    @GET("v1/fine-tunes")
    Single<OpenAiResponse<FineTuneResponse>> fineTunes();


    /**
     * 检索微调作业
     *
     * @return Single FineTuneResponse
     */
    @GET("v1/fine-tunes/{fine_tune_id}")
    Single<FineTuneResponse> retrieveFineTune(@Path("fine_tune_id") String fineTuneId);

    /**
     * 取消微调作业
     *
     * @return Single FineTuneResponse
     */
    @POST("v1/fine-tunes/{fine_tune_id}/cancel")
    Single<FineTuneResponse> cancelFineTune(@Path("fine_tune_id") String fineTuneId);

    /**
     * 微调作业事件列表
     *
     * @return Single OpenAiResponse Event
     */
    @GET("v1/fine-tunes/{fine_tune_id}/events")
    Single<OpenAiResponse<Event>> fineTuneEvents(@Path("fine_tune_id") String fineTuneId);

    /**
     * 删除微调作业模型
     * Delete a fine-tuned model. You must have the Owner role in your organization.
     *
     * @return Single DeleteResponse
     */
    @DELETE("v1/models/{model}")
    Single<FineTuneDeleteResponse> deleteFineTuneModel(@Path("model") String model);


    /**
     * 引擎列表
     * 官方已废弃此接口
     *
     * @return Single OpenAiResponse Engine
     */
    @Deprecated
    @GET("v1/engines")
    Single<OpenAiResponse<Engine>> engines();

    /**
     * 检索引擎
     * 官方已废弃此接口
     *
     * @param engineId
     * @return Engine
     */
    @Deprecated
    @GET("v1/engines/{engine_id}")
    Single<Engine> engine(@Path("engine_id") String engineId);


    /**
     * 最新版的GPT-3.5 chat completion 更加贴近官方网站的问答模型
     *
     * @param chatCompletion chat completion
     * @return 返回答案
     */
    @POST("v1/chat/completions")
    Single<ChatCompletionResponse> chatCompletion(@Body ChatCompletion chatCompletion);


    /**
     * 语音转文字
     *
     * @param file           语音文件
     * @param requestBodyMap 参数
     * @return 文本
     */
    @Multipart
    @POST("v1/audio/transcriptions")
    Single<WhisperResponse> speechToTextTranscriptions(@Part MultipartBody.Part file,
                                                       @PartMap() Map<String, RequestBody> requestBodyMap);

    /**
     * 语音翻译：目前仅支持翻译为英文
     *
     * @param file           语音文件
     * @param requestBodyMap 参数
     * @return 文本
     */
    @Multipart
    @POST("v1/audio/translations")
    Single<WhisperResponse> speechToTextTranslations(@Part MultipartBody.Part file,
                                                     @PartMap() Map<String, RequestBody> requestBodyMap);

    /**
     * 余额查询
     * 官方禁止访问此接口
     *
     * @return 余额结果
     */
    @GET("dashboard/billing/credit_grants")
    @Deprecated
    Single<CreditGrantsResponse> creditGrants();

    /**
     * 账户信息查询：里面包含总金额（美元）等信息
     *
     * @return
     */
    @GET("v1/dashboard/billing/subscription")
    Single<Subscription> subscription();

    /**
     * 账户调用接口消耗金额信息查询
     * totalUsage = 账户总使用金额（美分）
     *
     * @param starDate
     * @param endDate
     * @return
     */
    @GET("v1/dashboard/billing/usage")
    Single<BillingUsage> billingUsage(@Query("start_date") LocalDate starDate, @Query("end_date") LocalDate endDate);
}
