
package com.agiletestingframework.candystore.webservices.schemas.com.cdyne.ws.weatherws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cdyne.ws.weatherws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ArrayOfWeatherDescription_QNAME = new QName("http://ws.cdyne.com/WeatherWS/", "ArrayOfWeatherDescription");
    private final static QName _WeatherReturn_QNAME = new QName("http://ws.cdyne.com/WeatherWS/", "WeatherReturn");
    private final static QName _ForecastReturn_QNAME = new QName("http://ws.cdyne.com/WeatherWS/", "ForecastReturn");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cdyne.ws.weatherws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetWeatherInformationResponse }
     * @return
     *     possible object is
     *     {@link GetWeatherInformationResponse }
     */
    public GetWeatherInformationResponse createGetWeatherInformationResponse() {
        return new GetWeatherInformationResponse();
    }

    /**
     * Create an instance of {@link ArrayOfWeatherDescription }
     * @return
     *     possible object is
     *     {@link ArrayOfWeatherDescription }
     */
    public ArrayOfWeatherDescription createArrayOfWeatherDescription() {
        return new ArrayOfWeatherDescription();
    }

    /**
     * Create an instance of {@link GetCityForecastByZIP }
     * @return
     *     possible object is
     *     {@link GetCityForecastByZIP }
     */
    public GetCityForecastByZIP createGetCityForecastByZIP() {
        return new GetCityForecastByZIP();
    }

    /**
     * Create an instance of {@link GetCityWeatherByZIPResponse }
     * @return
     *     possible object is
     *     {@link GetCityWeatherByZIPResponse }
     */
    public GetCityWeatherByZIPResponse createGetCityWeatherByZIPResponse() {
        return new GetCityWeatherByZIPResponse();
    }

    /**
     * Create an instance of {@link WeatherReturn }
     * @return
     *     possible object is
     *     {@link WeatherReturn }
     */
    public WeatherReturn createWeatherReturn() {
        return new WeatherReturn();
    }

    /**
     * Create an instance of {@link GetWeatherInformation }
     * @return
     *     possible object is
     *     {@link GetWeatherInformation }
     */
    public GetWeatherInformation createGetWeatherInformation() {
        return new GetWeatherInformation();
    }

    /**
     * Create an instance of {@link GetCityWeatherByZIP }
     * @return
     *     possible object is
     *     {@link GetCityWeatherByZIP }
     */
    public GetCityWeatherByZIP createGetCityWeatherByZIP() {
        return new GetCityWeatherByZIP();
    }

    /**
     * Create an instance of {@link ForecastReturn }
     * @return
     *     possible object is
     *     {@link ForecastReturn }
     */
    public ForecastReturn createForecastReturn() {
        return new ForecastReturn();
    }

    /**
     * Create an instance of {@link GetCityForecastByZIPResponse }
     * @return
     *     possible object is
     *     {@link GetCityForecastByZIPResponse }
     */
    public GetCityForecastByZIPResponse createGetCityForecastByZIPResponse() {
        return new GetCityForecastByZIPResponse();
    }

    /**
     * Create an instance of {@link POP }
     * @return
     *     possible object is
     *     {@link POP }
     */
    public POP createPOP() {
        return new POP();
    }

    /**
     * Create an instance of {@link Temp }
     * @return
     *     possible object is
     *     {@link Temp }
     */
    public Temp createTemp() {
        return new Temp();
    }

    /**
     * Create an instance of {@link WeatherDescription }
     * @return
     *     possible object is
     *     {@link WeatherDescription }
     */
    public WeatherDescription createWeatherDescription() {
        return new WeatherDescription();
    }

    /**
     * Create an instance of {@link Forecast }
     * @return
     *     possible object is
     *     {@link Forecast }
     */
    public Forecast createForecast() {
        return new Forecast();
    }

    /**
     * Create an instance of {@link ArrayOfForecast }
     * @return
     *     possible object is
     *     {@link ArrayOfForecast }
     */
    public ArrayOfForecast createArrayOfForecast() {
        return new ArrayOfForecast();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfWeatherDescription }{@code >}}
     * @param value
     *     allowed object is
     *     {@link ArrayOfWeatherDescription }
     * @return
     *     possible object is
     *     {@link ArrayOfWeatherDescription }
     */
    @XmlElementDecl(namespace = "http://ws.cdyne.com/WeatherWS/", name = "ArrayOfWeatherDescription")
    public JAXBElement<ArrayOfWeatherDescription> createArrayOfWeatherDescription(ArrayOfWeatherDescription value) {
        return new JAXBElement<ArrayOfWeatherDescription>(_ArrayOfWeatherDescription_QNAME, ArrayOfWeatherDescription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeatherReturn }{@code >}}
     * @param value
     *     allowed object is
     *     {@link WeatherReturn }
     * @return
     *     possible object is
     *     {@link WeatherReturn }
     */
    @XmlElementDecl(namespace = "http://ws.cdyne.com/WeatherWS/", name = "WeatherReturn")
    public JAXBElement<WeatherReturn> createWeatherReturn(WeatherReturn value) {
        return new JAXBElement<WeatherReturn>(_WeatherReturn_QNAME, WeatherReturn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForecastReturn }{@code >}}
     * @param value
     *     allowed object is
     *     {@link ForecastReturn }
     * @return
     *     possible object is
     *     {@link ForecastReturn }
     */
    @XmlElementDecl(namespace = "http://ws.cdyne.com/WeatherWS/", name = "ForecastReturn")
    public JAXBElement<ForecastReturn> createForecastReturn(ForecastReturn value) {
        return new JAXBElement<ForecastReturn>(_ForecastReturn_QNAME, ForecastReturn.class, null, value);
    }

}
