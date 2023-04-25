package de.vw.f73.kitereisen.loader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.vw.f73.kitereisen.location.Location;
import de.vw.f73.kitereisen.utils.Utils;

@Service
public class LoaderService {

    private List<Location> locations = new ArrayList<>();
    private StringBuilder output = new StringBuilder();

    public void getAllStatistics() {
        loadLocations();
        for (Location location : this.locations) {
            RestTemplate restTemplate = new RestTemplate();
            String html = restTemplate.getForObject(location.getUrl(), String.class);
//            String html = Utils.read("full_html");
            List<String> extracted = Utils.extractStrings(html);
            appendToOutput(location, extracted);
        }
        Utils.write(this.output.toString());
    }

    private void appendToOutput(Location location, List<String> extracted) {
        if (extracted.size() == 4) {
            this.output.append(location.getName()).append(",Wind,");
            this.output.append(extracted.get(0).replace('|', ',')).append("\n");
            this.output.append(location.getName()).append(",Regen,");
            this.output.append(extracted.get(1).replace('|', ',')).append("\n");
            this.output.append(location.getName()).append(",Luft,");
            this.output.append(extracted.get(2).replace('|', ',')).append("\n");
            this.output.append(location.getName()).append(",Wasser,");
            this.output.append(extracted.get(3).replace('|', ',')).append("\n");
        } else {
            appendWithoutRainData(location, extracted);
        }
    }

    private void loadLocations() {
        String rest = "https://www.kitereisen.tv/besten-kitespots-kitesurfen-";
        String page = "https://www.kitereisen.tv/";

        // rain missing
        this.locations.add(new Location("Romo", rest + "roemoe-daenemark/"));
        this.locations.add(new Location("Tarifa", rest + "tarifa/"));
        this.locations.add(new Location("Mallorca", rest + "mallorca/"));

        // no data
//      this.locations.add(new Location("Oahu", rest + "oahu-hawaii/"));

        // data complete
        this.locations.add(new Location("Ringkobing", rest + "ringkobing-fjord-daenemark/"));
        this.locations.add(new Location("Fehmarn", rest + "fehmarn-ostsee/"));
        this.locations.add(new Location("La Reunion", rest + "la-reunion/"));
        this.locations.add(new Location("Klitmoeller", rest + "klitmoeller-limfjord-daenemark/"));
        this.locations.add(new Location("Ruegen", rest + "ruegen-ostsee/"));
        this.locations.add(new Location("Nordfriesland", rest + "nordfriesland-nordsee/"));
        this.locations.add(new Location("SPO", rest + "sankt-peter-ording-deutschland/"));
        this.locations.add(new Location("Ostfriesland", rest + "ostfriesland-nordsee/"));
        this.locations.add(new Location("SH", rest + "schleswig-holstein-ostsee/"));
        this.locations.add(new Location("MV", rest + "mecklenburg-vorpommern-ostsee/"));
        this.locations.add(new Location("Usedom", rest + "usedom-ostsee/"));
        this.locations.add(new Location("Beauduc", rest + "beauduc-frankreich/"));
        this.locations.add(new Location("Leucate", rest + "leucate-frankreich/"));
        this.locations.add(new Location("Limnos", rest + "limnos-griechenland/"));
        this.locations.add(new Location("Kykladen", rest + "kykladen-griechenland/"));
        this.locations.add(new Location("Kos", rest + "kos-griechenland/"));
        this.locations.add(new Location("Rhodos", rest + "rhodos-griechenland/"));
        this.locations.add(new Location("Sizilien", rest + "sizilien-italien/"));
        this.locations.add(new Location("Gardasee", rest + "gardasee-italien/"));
        this.locations.add(new Location("Sardinien", rest + "sardinien/"));
        this.locations.add(new Location("Talamone", rest + "talamone-italien/"));
        this.locations.add(new Location("Ulcinj", rest + "ulcinj-montenegro/"));
        this.locations.add(new Location("Westfriesland", rest + "westfriesland-niederlande/"));
        this.locations.add(new Location("Zeeland", rest + "zeeland-niederlande/"));
        this.locations.add(new Location("Holland", rest + "holland-niederlande/"));
        this.locations.add(new Location("Ijsselmeer", rest + "ijsselmeer-holland/"));
        this.locations.add(new Location("Adria", rest + "kroatien/"));
        this.locations.add(new Location("Hel", rest + "hel-polen/"));
        this.locations.add(new Location("Alvor", page + "algarve-alvor-portugal-besten-kitespots-kitesurfen/"));
        this.locations.add(new Location("Lissabon", rest + "lissabon/"));
        this.locations.add(new Location("Fuerteventura", rest + "fuerteventura/"));
        this.locations.add(new Location("Gran Canaria", rest + "gran-canaria-spanien/"));
        this.locations.add(new Location("Teneriffa", rest + "el-medano-teneriffa/"));
        this.locations.add(new Location("Goekova", rest + "goekova-akyaka-tuerkei/"));
        this.locations.add(new Location("Ilha do Guajiru", page + "ilha-do-guajiru-besten-kitespots-kitesurfen/"));
        this.locations.add(new Location("Ceara", page + "ceara-brasilien-besten-kitespots-kitesurfen/"));
        this.locations.add(new Location("Cumbuco", page + "cumbuco-fortaleza-besten-kitespots-kitesurfen/"));
        this.locations.add(new Location("Florianopolis", page + "florianopolis-besten-kitespots-kitesurfen/"));
        this.locations
                .add(new Location("Rio Grande do Norte", page + "rio-grande-do-norte-kitespots-reisezeit-kitesurfen/"));
        this.locations.add(new Location("Columbia River", rest + "columbia-river/"));
        this.locations.add(new Location("Cape Hatteras", page + "cape-hatteras-kitespots-reisezeit-kitesurfen/"));
        this.locations.add(new Location("Guam", rest + "guam/"));
        this.locations.add(new Location("Kalifornien", rest + "kalifornien-usa/"));
        this.locations.add(new Location("Florida", rest + "miami-florida/"));
        this.locations.add(new Location("Maui", rest + "maui-hawaii/"));
        this.locations.add(new Location("Puerto Rico", rest + "puerto-rico/"));
        this.locations.add(new Location("South Padre Island", rest + "south-padre-island/"));
        this.locations.add(new Location("San Francisco", rest + "san-francisco-usa/"));
        this.locations.add(new Location("South Australia", page + "besten-kitespots-der-suedkueste-von-australien/"));
        this.locations.add(new Location("West Australia", page + "besten-kitespots-westkueste-australien/"));
        this.locations.add(new Location("Margaret River", page + "besten-kitespots-margaret-river-australien/"));
        this.locations.add(new Location("Adelaide", page + "besten-kitespots-adelaide-australien/"));
        this.locations.add(new Location("Tasmanien", rest + "tasmanien/"));
        this.locations.add(new Location("Hainan", page + "besten-kitespots-hainan-china/"));
        this.locations.add(new Location("Bali", rest + "bali-indonesien/"));
        this.locations.add(new Location("Sumbawa", page + "sumbawa-kitespots-reisezeit-kitesurfen/"));
        this.locations.add(new Location("Golf von Thailand", page + "besten-kitespots-golf-von-thailand/"));
        this.locations.add(new Location("Ko Samui", rest + "ko-samui-thailand/"));
        this.locations.add(new Location("Phuket", rest + "phuket-thailand/"));
        this.locations.add(new Location("Mui Ne", rest + "mui-ne-vietnam/"));
        this.locations.add(new Location("Sal", rest + "sal-kap-verde/"));
        this.locations.add(new Location("Dahab", rest + "dahab-aegypten/"));
        this.locations.add(new Location("El Gouna", rest + "el-gouna-aegypten/"));
        this.locations.add(new Location("Soma Bay", rest + "soma-bay-aegypten/"));
        this.locations.add(new Location("Hurghada", rest + "hurghada-aegypten/"));
        this.locations.add(new Location("Hamata", rest + "hamata-aegypten/"));
        this.locations.add(new Location("Essaouira", rest + "essaouira-marokko/"));
        this.locations.add(new Location("Dakhla", rest + "dakhla-marokko/"));
        this.locations.add(new Location("Mauritius", page + "mauritius-kitespots-reisezeit-kitesurfen/"));
        this.locations.add(new Location("Rodrigues", rest + "rodrigues/"));
        this.locations.add(new Location("Durban", page + "durban-kitespots-reisezeit-kitesurfen/"));
        this.locations.add(new Location("Kapstadt", page + "besten-kitespots-kapregion-suedafrika/"));
        this.locations.add(new Location("Langebaan", page + "besten-kitespots-der-westkueste-suedafrika/"));
        this.locations.add(new Location("Overberg", page + "overberg-besten-kitespots-kitesurfen/"));
        this.locations.add(new Location("Djerba", rest + "djerba/"));
        this.locations.add(new Location("Zarzis", rest + "zarzis-tunesien/"));
    }

    private void appendWithoutRainData(Location location, List<String> extracted) {
        this.output.append(location.getName()).append(",Wind,");
        this.output.append(extracted.get(0).replace('|', ',')).append("\n");
        this.output.append(location.getName()).append(",Luft,");
        this.output.append(extracted.get(1).replace('|', ',')).append("\n");
        this.output.append(location.getName()).append(",Wasser,");
        this.output.append(extracted.get(2).replace('|', ',')).append("\n");
        System.err.println(location.getUrl());
    }

}
