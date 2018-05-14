package com.urp.tool;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.context.annotation.Bean;

public class JasonConfig {

	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		/*objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);*/
		SimpleModule simpleModule = new SimpleModule("SimpleModule", null);
		simpleModule.addSerializer(JsonResult.class, new CustomJsonResultSerializer());
		objectMapper.registerModule(simpleModule);
		return objectMapper;
	}
	
	public static class CustomJsonResultSerializer extends JsonSerializer<JsonResult> {

	    public CustomJsonResultSerializer() {
	    }


		public void serialize(JsonResult value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
			gen.writeStartObject();
			if(value.getCode().equals("200")) {
				gen.writeObjectField("code", 0);
			}else {
				gen.writeObjectField("code", Integer.parseInt(value.getCode()));
			}
			gen.writeStringField("msg", value.getMsg());
			Object data = value.getData();
			gen.writeObjectField("data", data);
			/*if(data instanceof PageQuery ) {
				PageQuery query = (PageQuery)(data);
				gen.writeObjectField("count", query.getTotalRow());
				gen.writeObjectField("data", query.getList());
			}else {
				
				gen.writeObjectField("data", data);
			}*/
			gen.writeEndObject();
		}

	}
}
