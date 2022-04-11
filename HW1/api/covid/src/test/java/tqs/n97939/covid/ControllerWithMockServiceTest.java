package tqs.n97939.covid;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import tqs.n97939.covid.controller.Controller;
import tqs.n97939.covid.service.CovidService;

import java.util.Objects;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(Controller.class)
public class ControllerWithMockServiceTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CovidService service;

    private static final ResponseEntity<String> COUNTRIES_RE = new ResponseEntity<>(
            "{\n" +
                    "    \"get\": \"countries\",\n" +
                    "    \"parameters\": [],\n" +
                    "    \"errors\": [],\n" +
                    "    \"results\": 233,\n" +
                    "    \"response\": [\n" +
                    "        \"Afghanistan\",\n" +
                    "        \"Albania\",\n" +
                    "        \"Algeria\",\n" +
                    "        \"Andorra\",\n" +
                    "        \"Angola\",\n" +
                    "        \"Anguilla\",\n" +
                    "        \"Antigua-and-Barbuda\",\n" +
                    "        \"Argentina\",\n" +
                    "        \"Armenia\",\n" +
                    "        \"Aruba\",\n" +
                    "        \"Australia\",\n" +
                    "        \"Austria\",\n" +
                    "        \"Azerbaijan\",\n" +
                    "        \"Bahamas\",\n" +
                    "        \"Bahrain\",\n" +
                    "        \"Bangladesh\",\n" +
                    "        \"Barbados\",\n" +
                    "        \"Belarus\",\n" +
                    "        \"Belgium\",\n" +
                    "        \"Belize\",\n" +
                    "        \"Benin\",\n" +
                    "        \"Bermuda\",\n" +
                    "        \"Bhutan\",\n" +
                    "        \"Bolivia\",\n" +
                    "        \"Bosnia-and-Herzegovina\",\n" +
                    "        \"Botswana\",\n" +
                    "        \"Brazil\",\n" +
                    "        \"British-Virgin-Islands\",\n" +
                    "        \"Brunei\",\n" +
                    "        \"Bulgaria\",\n" +
                    "        \"Burkina-Faso\",\n" +
                    "        \"Burundi\",\n" +
                    "        \"Cabo-Verde\",\n" +
                    "        \"Cambodia\",\n" +
                    "        \"Cameroon\",\n" +
                    "        \"Canada\",\n" +
                    "        \"CAR\",\n" +
                    "        \"Caribbean-Netherlands\",\n" +
                    "        \"Cayman-Islands\",\n" +
                    "        \"Chad\",\n" +
                    "        \"Channel-Islands\",\n" +
                    "        \"Chile\",\n" +
                    "        \"China\",\n" +
                    "        \"Colombia\",\n" +
                    "        \"Comoros\",\n" +
                    "        \"Congo\",\n" +
                    "        \"Cook-Islands\",\n" +
                    "        \"Costa-Rica\",\n" +
                    "        \"Croatia\",\n" +
                    "        \"Cuba\",\n" +
                    "        \"Cura&ccedil;ao\",\n" +
                    "        \"Cyprus\",\n" +
                    "        \"Czechia\",\n" +
                    "        \"Denmark\",\n" +
                    "        \"Diamond-Princess\",\n" +
                    "        \"Diamond-Princess-\",\n" +
                    "        \"Djibouti\",\n" +
                    "        \"Dominica\",\n" +
                    "        \"Dominican-Republic\",\n" +
                    "        \"DRC\",\n" +
                    "        \"Ecuador\",\n" +
                    "        \"Egypt\",\n" +
                    "        \"El-Salvador\",\n" +
                    "        \"Equatorial-Guinea\",\n" +
                    "        \"Eritrea\",\n" +
                    "        \"Estonia\",\n" +
                    "        \"Eswatini\",\n" +
                    "        \"Ethiopia\",\n" +
                    "        \"Faeroe-Islands\",\n" +
                    "        \"Falkland-Islands\",\n" +
                    "        \"Fiji\",\n" +
                    "        \"Finland\",\n" +
                    "        \"France\",\n" +
                    "        \"French-Guiana\",\n" +
                    "        \"French-Polynesia\",\n" +
                    "        \"Gabon\",\n" +
                    "        \"Gambia\",\n" +
                    "        \"Georgia\",\n" +
                    "        \"Germany\",\n" +
                    "        \"Ghana\",\n" +
                    "        \"Gibraltar\",\n" +
                    "        \"Greece\",\n" +
                    "        \"Greenland\",\n" +
                    "        \"Grenada\",\n" +
                    "        \"Guadeloupe\",\n" +
                    "        \"Guam\",\n" +
                    "        \"Guatemala\",\n" +
                    "        \"Guinea\",\n" +
                    "        \"Guinea-Bissau\",\n" +
                    "        \"Guyana\",\n" +
                    "        \"Haiti\",\n" +
                    "        \"Honduras\",\n" +
                    "        \"Hong-Kong\",\n" +
                    "        \"Hungary\",\n" +
                    "        \"Iceland\",\n" +
                    "        \"India\",\n" +
                    "        \"Indonesia\",\n" +
                    "        \"Iran\",\n" +
                    "        \"Iraq\",\n" +
                    "        \"Ireland\",\n" +
                    "        \"Isle-of-Man\",\n" +
                    "        \"Israel\",\n" +
                    "        \"Italy\",\n" +
                    "        \"Ivory-Coast\",\n" +
                    "        \"Jamaica\",\n" +
                    "        \"Japan\",\n" +
                    "        \"Jordan\",\n" +
                    "        \"Kazakhstan\",\n" +
                    "        \"Kenya\",\n" +
                    "        \"Kiribati\",\n" +
                    "        \"Kuwait\",\n" +
                    "        \"Kyrgyzstan\",\n" +
                    "        \"Laos\",\n" +
                    "        \"Latvia\",\n" +
                    "        \"Lebanon\",\n" +
                    "        \"Lesotho\",\n" +
                    "        \"Liberia\",\n" +
                    "        \"Libya\",\n" +
                    "        \"Liechtenstein\",\n" +
                    "        \"Lithuania\",\n" +
                    "        \"Luxembourg\",\n" +
                    "        \"Macao\",\n" +
                    "        \"Madagascar\",\n" +
                    "        \"Malawi\",\n" +
                    "        \"Malaysia\",\n" +
                    "        \"Maldives\",\n" +
                    "        \"Mali\",\n" +
                    "        \"Malta\",\n" +
                    "        \"Marshall-Islands\",\n" +
                    "        \"Martinique\",\n" +
                    "        \"Mauritania\",\n" +
                    "        \"Mauritius\",\n" +
                    "        \"Mayotte\",\n" +
                    "        \"Mexico\",\n" +
                    "        \"Micronesia\",\n" +
                    "        \"Moldova\",\n" +
                    "        \"Monaco\",\n" +
                    "        \"Mongolia\",\n" +
                    "        \"Montenegro\",\n" +
                    "        \"Montserrat\",\n" +
                    "        \"Morocco\",\n" +
                    "        \"Mozambique\",\n" +
                    "        \"MS-Zaandam\",\n" +
                    "        \"MS-Zaandam-\",\n" +
                    "        \"Myanmar\",\n" +
                    "        \"Namibia\",\n" +
                    "        \"Nauru\",\n" +
                    "        \"Nepal\",\n" +
                    "        \"Netherlands\",\n" +
                    "        \"New-Caledonia\",\n" +
                    "        \"New-Zealand\",\n" +
                    "        \"Nicaragua\",\n" +
                    "        \"Niger\",\n" +
                    "        \"Nigeria\",\n" +
                    "        \"Niue\",\n" +
                    "        \"North-Macedonia\",\n" +
                    "        \"Norway\",\n" +
                    "        \"Oman\",\n" +
                    "        \"Pakistan\",\n" +
                    "        \"Palau\",\n" +
                    "        \"Palestine\",\n" +
                    "        \"Panama\",\n" +
                    "        \"Papua-New-Guinea\",\n" +
                    "        \"Paraguay\",\n" +
                    "        \"Peru\",\n" +
                    "        \"Philippines\",\n" +
                    "        \"Poland\",\n" +
                    "        \"Portugal\",\n" +
                    "        \"Puerto-Rico\",\n" +
                    "        \"Qatar\",\n" +
                    "        \"R&eacute;union\",\n" +
                    "        \"Romania\",\n" +
                    "        \"Russia\",\n" +
                    "        \"Rwanda\",\n" +
                    "        \"S-Korea\",\n" +
                    "        \"Saint-Helena\",\n" +
                    "        \"Saint-Kitts-and-Nevis\",\n" +
                    "        \"Saint-Lucia\",\n" +
                    "        \"Saint-Martin\",\n" +
                    "        \"Saint-Pierre-Miquelon\",\n" +
                    "        \"Samoa\",\n" +
                    "        \"San-Marino\",\n" +
                    "        \"Sao-Tome-and-Principe\",\n" +
                    "        \"Saudi-Arabia\",\n" +
                    "        \"Senegal\",\n" +
                    "        \"Serbia\",\n" +
                    "        \"Seychelles\",\n" +
                    "        \"Sierra-Leone\",\n" +
                    "        \"Singapore\",\n" +
                    "        \"Sint-Maarten\",\n" +
                    "        \"Slovakia\",\n" +
                    "        \"Slovenia\",\n" +
                    "        \"Solomon-Islands\",\n" +
                    "        \"Somalia\",\n" +
                    "        \"South-Africa\",\n" +
                    "        \"South-Sudan\",\n" +
                    "        \"Spain\",\n" +
                    "        \"Sri-Lanka\",\n" +
                    "        \"St-Barth\",\n" +
                    "        \"St-Vincent-Grenadines\",\n" +
                    "        \"Sudan\",\n" +
                    "        \"Suriname\",\n" +
                    "        \"Sweden\",\n" +
                    "        \"Switzerland\",\n" +
                    "        \"Syria\",\n" +
                    "        \"Taiwan\",\n" +
                    "        \"Tajikistan\",\n" +
                    "        \"Tanzania\",\n" +
                    "        \"Thailand\",\n" +
                    "        \"Timor-Leste\",\n" +
                    "        \"Togo\",\n" +
                    "        \"Tonga\",\n" +
                    "        \"Trinidad-and-Tobago\",\n" +
                    "        \"Tunisia\",\n" +
                    "        \"Turkey\",\n" +
                    "        \"Turks-and-Caicos\",\n" +
                    "        \"UAE\",\n" +
                    "        \"Uganda\",\n" +
                    "        \"UK\",\n" +
                    "        \"Ukraine\",\n" +
                    "        \"Uruguay\",\n" +
                    "        \"US-Virgin-Islands\",\n" +
                    "        \"USA\",\n" +
                    "        \"Uzbekistan\",\n" +
                    "        \"Vanuatu\",\n" +
                    "        \"Vatican-City\",\n" +
                    "        \"Venezuela\",\n" +
                    "        \"Vietnam\",\n" +
                    "        \"Wallis-and-Futuna\",\n" +
                    "        \"Western-Sahara\",\n" +
                    "        \"Yemen\",\n" +
                    "        \"Zambia\",\n" +
                    "        \"Zimbabwe\"\n" +
                    "    ]\n" +
                    "}",
            HttpStatus.OK
    );

    private static final ResponseEntity<String> COUNTRIES_STAN = new ResponseEntity<>(
            "{\n" +
                    "    \"get\": \"countries\",\n" +
                    "    \"parameters\": {\n" +
                    "        \"search\": \"stan\"\n" +
                    "    },\n" +
                    "    \"errors\": [],\n" +
                    "    \"results\": 6,\n" +
                    "    \"response\": [\n" +
                    "        \"Afghanistan\",\n" +
                    "        \"Kazakhstan\",\n" +
                    "        \"Kyrgyzstan\",\n" +
                    "        \"Pakistan\",\n" +
                    "        \"Tajikistan\",\n" +
                    "        \"Uzbekistan\"\n" +
                    "    ]\n" +
                    "}",
            HttpStatus.OK
    );


    private static final ResponseEntity<String> STATS_USA_RE = new ResponseEntity<>(
            "{\n" +
                    "    \"get\": \"statistics\",\n" +
                    "    \"parameters\": {\n" +
                    "        \"country\": \"usa\"\n" +
                    "    },\n" +
                    "    \"errors\": [],\n" +
                    "    \"results\": 1,\n" +
                    "    \"response\": [\n" +
                    "        {\n" +
                    "            \"continent\": \"North-America\",\n" +
                    "            \"country\": \"USA\",\n" +
                    "            \"population\": 334437650,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": \"+4584\",\n" +
                    "                \"active\": 1141915,\n" +
                    "                \"critical\": 1615,\n" +
                    "                \"recovered\": 79919151,\n" +
                    "                \"1M_pop\": \"245407\",\n" +
                    "                \"total\": 82073260\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": \"+38\",\n" +
                    "                \"1M_pop\": \"3027\",\n" +
                    "                \"total\": 1012194\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": \"2964389\",\n" +
                    "                \"total\": 991403221\n" +
                    "            },\n" +
                    "            \"day\": \"2022-04-11\",\n" +
                    "            \"time\": \"2022-04-11T20:15:02+00:00\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}",
            HttpStatus.OK
    );

    private static final ResponseEntity<String> HISTORY_DP_RE = new ResponseEntity<>(
            "{\n" +
                    "    \"get\": \"history\",\n" +
                    "    \"parameters\": {\n" +
                    "        \"country\": \"diamond-princess\"\n" +
                    "    },\n" +
                    "    \"errors\": [],\n" +
                    "    \"results\": 10,\n" +
                    "    \"response\": [\n" +
                    "        {\n" +
                    "            \"continent\": null,\n" +
                    "            \"country\": \"Diamond-Princess\",\n" +
                    "            \"population\": null,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"active\": 0,\n" +
                    "                \"critical\": null,\n" +
                    "                \"recovered\": 699,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 712\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 13\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": null\n" +
                    "            },\n" +
                    "            \"day\": \"2022-04-11\",\n" +
                    "            \"time\": \"2022-04-11T20:45:04+00:00\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"continent\": null,\n" +
                    "            \"country\": \"Diamond-Princess\",\n" +
                    "            \"population\": null,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"active\": 40,\n" +
                    "                \"critical\": 4,\n" +
                    "                \"recovered\": 659,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 712\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 13\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": null\n" +
                    "            },\n" +
                    "            \"day\": \"2020-12-03\",\n" +
                    "            \"time\": \"2020-12-03T22:00:13+00:00\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"continent\": null,\n" +
                    "            \"country\": \"Diamond-Princess\",\n" +
                    "            \"population\": null,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"active\": 48,\n" +
                    "                \"critical\": 4,\n" +
                    "                \"recovered\": 651,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 712\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 13\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": null\n" +
                    "            },\n" +
                    "            \"day\": \"2020-10-10\",\n" +
                    "            \"time\": \"2020-10-10T05:00:07+00:00\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"continent\": null,\n" +
                    "            \"country\": \"Diamond-Princess\",\n" +
                    "            \"population\": null,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"active\": 48,\n" +
                    "                \"critical\": 4,\n" +
                    "                \"recovered\": 651,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 712\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 13\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": null\n" +
                    "            },\n" +
                    "            \"day\": \"2020-05-29\",\n" +
                    "            \"time\": \"2020-05-29T17:45:07+00:00\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"continent\": null,\n" +
                    "            \"country\": \"Diamond-Princess\",\n" +
                    "            \"population\": null,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"active\": 48,\n" +
                    "                \"critical\": 4,\n" +
                    "                \"recovered\": 651,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 712\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 13\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": null\n" +
                    "            },\n" +
                    "            \"day\": \"2020-05-29\",\n" +
                    "            \"time\": \"2020-05-29T00:15:06+00:00\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"continent\": null,\n" +
                    "            \"country\": \"Diamond-Princess\",\n" +
                    "            \"population\": null,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"active\": 54,\n" +
                    "                \"critical\": 4,\n" +
                    "                \"recovered\": 645,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 712\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 13\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": null\n" +
                    "            },\n" +
                    "            \"day\": \"2020-05-10\",\n" +
                    "            \"time\": \"2020-05-10T23:00:05+00:00\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"continent\": null,\n" +
                    "            \"country\": \"Diamond-Princess\",\n" +
                    "            \"population\": null,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"active\": 55,\n" +
                    "                \"critical\": 7,\n" +
                    "                \"recovered\": 644,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 712\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 13\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": null\n" +
                    "            },\n" +
                    "            \"day\": \"2020-04-23\",\n" +
                    "            \"time\": \"2020-04-23T00:15:05+00:00\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"continent\": null,\n" +
                    "            \"country\": \"Diamond-Princess\",\n" +
                    "            \"population\": null,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"active\": 56,\n" +
                    "                \"critical\": 7,\n" +
                    "                \"recovered\": 644,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 712\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 12\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": null\n" +
                    "            },\n" +
                    "            \"day\": \"2020-04-17\",\n" +
                    "            \"time\": \"2020-04-17T05:15:05+00:00\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"continent\": null,\n" +
                    "            \"country\": \"Diamond-Princess\",\n" +
                    "            \"population\": null,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"active\": 61,\n" +
                    "                \"critical\": 7,\n" +
                    "                \"recovered\": 639,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 712\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 12\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": null\n" +
                    "            },\n" +
                    "            \"day\": \"2020-04-16\",\n" +
                    "            \"time\": \"2020-04-16T02:15:05+00:00\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"continent\": null,\n" +
                    "            \"country\": \"Diamond-Princess\",\n" +
                    "            \"population\": null,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"active\": 82,\n" +
                    "                \"critical\": 10,\n" +
                    "                \"recovered\": 619,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 712\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 11\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": null\n" +
                    "            },\n" +
                    "            \"day\": \"2020-04-14\",\n" +
                    "            \"time\": \"2020-04-14T00:30:11+00:00\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}",
            HttpStatus.OK
    );

    private static final ResponseEntity<String> HISTORY_DP_DAY_RE = new ResponseEntity<>(
            "{\n" +
                    "    \"get\": \"history\",\n" +
                    "    \"parameters\": {\n" +
                    "        \"country\": \"diamond-princess\",\n" +
                    "        \"day\": \"2020-04-14\"\n" +
                    "    },\n" +
                    "    \"errors\": [],\n" +
                    "    \"results\": 1,\n" +
                    "    \"response\": [\n" +
                    "        {\n" +
                    "            \"continent\": null,\n" +
                    "            \"country\": \"Diamond-Princess\",\n" +
                    "            \"population\": null,\n" +
                    "            \"cases\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"active\": 82,\n" +
                    "                \"critical\": 10,\n" +
                    "                \"recovered\": 619,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 712\n" +
                    "            },\n" +
                    "            \"deaths\": {\n" +
                    "                \"new\": null,\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": 11\n" +
                    "            },\n" +
                    "            \"tests\": {\n" +
                    "                \"1M_pop\": null,\n" +
                    "                \"total\": null\n" +
                    "            },\n" +
                    "            \"day\": \"2020-04-14\",\n" +
                    "            \"time\": \"2020-04-14T00:30:11+00:00\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}",
            HttpStatus.OK
    );

    @Test
    void testGetCountries() throws Exception {
        when(service.getCountries(null)).thenReturn(COUNTRIES_RE);
        when(service.getCountries("stan")).thenReturn(COUNTRIES_STAN);
        mvc.perform(get("/api/countries").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Objects.requireNonNull(COUNTRIES_RE.getBody())));
        mvc.perform(get("/api/countries?search=stan").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Objects.requireNonNull(COUNTRIES_STAN.getBody())));
        verify(service, times(1)).getCountries(null);
        verify(service, times(1)).getCountries("stan");
    }

    @Test
    void testGetCurrentStatistics() throws Exception {
        when(service.getCurrentStatistics("usa")).thenReturn(STATS_USA_RE);
        mvc.perform(get("/api/statistics?country=usa").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Objects.requireNonNull(STATS_USA_RE.getBody())));
        verify(service, times(1)).getCurrentStatistics("usa");
    }

    @Test
    void testGetHistory() throws Exception {
        when(service.getHistory("diamond-princess", null)).thenReturn(HISTORY_DP_RE);
        when(service.getHistory("diamond-princess", "2020-04-14")).thenReturn(HISTORY_DP_DAY_RE);
        mvc.perform(get("/api/history?country=diamond-princess").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Objects.requireNonNull(HISTORY_DP_RE.getBody())));
        mvc.perform(get("/api/history?country=diamond-princess&day=2020-04-14").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(Objects.requireNonNull(HISTORY_DP_DAY_RE.getBody())));
        verify(service, times(1)).getHistory("diamond-princess", null);
        verify(service, times(1)).getHistory("diamond-princess", "2020-04-14");
    }
}