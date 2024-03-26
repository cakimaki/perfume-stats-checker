package org.example.perfumestatschecker;

import org.example.perfumestatschecker.services.dataintegration.sitebots.fetchUrlsByBrand.FetchPerfumesByBrand;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class PerfumeStatsCheckerApplication implements CommandLineRunner {
	
	
	/*@Autowired
	private WebContentFetcher webContentFetcher;
	@Autowired
	private PerfumeDataSavingService perfumeDataSavingService;
	@Autowired
	@Qualifier("NotinoProcessingStrategy")
	private DataParsingStrategy notinoProcessingStrategy;*/
	@Autowired
	private FetchPerfumesByBrand fetchPerfumeUrl;
	public static void main(String[] args) {
		SpringApplication.run(PerfumeStatsCheckerApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		//List<String> urls = fetchPerfumeUrl.fetchUrlsByBrand("notino","Tom Ford");
		//System.out.println(urls);
		//System.out.println("Echo");
		//jsonProcessingService.processJsonFromUrl("https://www.notino.bg/tom-ford/eau-de-soleil-blanc-toaletna-voda-uniseks/p-16097522/");
		// Call the processAndSavePerfumeData method of the NotinoProcessingStrategy
		
		//todo
		// nothin just pointing that this is working process of saving perfume (all services called here)
		/*List<FilteredPerfumeDto> filteredPerfumeDto = new ArrayList<FilteredPerfumeDto>();
		System.out.println(filteredPerfumeDto);
		String jsonResponse = webContentFetcher.fetchJsonFromUrl("https://www.notino.bg/tom-ford/eau-de-soleil-blanc-toaletna-voda-uniseks/");
		filteredPerfumeDto = notinoProcessingStrategy.parseDataStringIntoObject(jsonResponse);
		TimeUnit.SECONDS.sleep(5);
		
		System.out.printf("\n");
		System.out.println(filteredPerfumeDto.toString());
		System.out.printf("eho");
		perfumeDataSavingService.persistFilteredPerfumeData(filteredPerfumeDto);*/
		
		
	}
	//String jsonResponse = "{\"@context\":\"https://schema.org\",\"@type\":\"Product\",\"@id\":\"https://www.notino.bg/tom-ford/eau-de-soleil-blanc-toaletna-voda-uniseks/\",\"sku\":\"TOFESBU_AEDT10\",\"gtin13\":\"888066075114\",\"category\":\"тоалетна вода унисекс\",\"name\":\"TOM FORD Eau de Soleil Blanc\",\"description\":\"&lt;p&gt;&lt;strong&gt;Свеж, сияен аромат, вдъхновен от ясното бяло слънце.&lt;/strong&gt;&lt;/p&gt;&lt;p&gt;Сияйно слънце и облаци, които се отразяват и блещукат по повърхността на морето, се крият под капачката на дамската тоалетна вода Tom Ford Eau de Soleil Blanc. Едно единствено вдишване ще ви пренесе на далечен частен остров и ще ви дари с незабавен прилив на енергия.&lt;/p&gt;&lt;ul&gt;&lt;li&gt;цветен аромат с акорди на амбра&lt;/li&gt;&lt;li&gt;сияен и силно пристрастяващ&lt;/li&gt;&lt;li&gt;във флакон, напомнящ шахматна фигурка&lt;/li&gt;&lt;/ul&gt;&lt;p&gt;&lt;strong&gt;Съставки на аромата&lt;/strong&gt;&lt;br&gt;Уводът принадлежи на цитрусовата целувка на бергамот и горчив портокал. След миг те се смесват с петигрейн и цветове иланг-иланг от Коморските острови. През ароматната композиция нежно преминават нотки на шам фъстък и акорд Coco de Mer, които внасят топлина в уханието. След нанасяне не търкайте аромата по кожата, за да дадете възможност на ароматната композиция да се развие правилно.&lt;/p&gt;&lt;p&gt;&lt;strong&gt;История на аромата&lt;/strong&gt;&lt;br&gt;Ароматът Tom Ford Eau de Soleil Blanc сякаш е създаден за всички любители на свежите цитрусови акорди. Той препраща към парфюмната вода Tom Ford Eau de Soleil, но се представя с още по-свежа композиция. „Мигновен прилив на вибрации, които ви канят да се впуснете в ново преживяване, съпровождано от аромата Soleil.“ – Tom Ford&lt;/p&gt;\",\"brand\":{\"@type\":\"Brand\",\"name\":\"TOM FORD\"},\"image\":[\"https://cdn.notinoimg.com/order_2k/tom-ford/888066075114_01-o/tom-ford-eau-de-soleil-blanc_.jpg\",\"https://cdn.notinoimg.com/order_2k/tom-ford/888066075114_02-o/tom-ford-eau-de-soleil-blanc_.jpg\",\"https://cdn.notinoimg.com/order_2k/tom-ford/888066075084_03/tom-ford-eau-de-soleil-blanc_.jpg\"],\"offers\":[{\"@type\":\"Offer\",\"name\":\"TOM FORD Eau de Soleil Blanc 100 мл.\",\"availability\":\"https://schema.org/InStock\",\"price\":362,\"priceCurrency\":\"BGN\",\"itemCountry\":\"BG\",\"sku\":\"TOFESBU_AEDT10\",\"url\":\"/tom-ford/eau-de-soleil-blanc-toaletna-voda-uniseks/p-16097522/\",\"image\":\"https://cdn.notinoimg.com/order_2k/tom-ford/888066075114_01-o/tom-ford-eau-de-soleil-blanc_.jpg\"},{\"@type\":\"Offer\",\"name\":\"TOM FORD Eau de Soleil Blanc 50 мл.\",\"availability\":\"https://schema.org/InStock\",\"price\":260.3,\"priceCurrency\":\"BGN\",\"itemCountry\":\"BG\",\"sku\":\"TOFESBU_AEDT50\",\"url\":\"/tom-ford/eau-de-soleil-blanc-toaletna-voda-uniseks/p-16097531/\",\"image\":\"https://cdn.notinoimg.com/order_2k/tom-ford/888066075084_01-o/tom-ford-eau-de-soleil-blanc_.jpg\"}]};";
}
