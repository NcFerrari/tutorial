window.onload = function () {
    new Manager();
}

//název záznamu v localStorage by mohl být nastavovatelný v konfiguraci
//mohl by exitovat taktéž v konfiguraci přepínač, jestli se to má ukládat do lokalStorage nebo souboru nebo někam jinam
//názvy - vylepšit :D
//značka ideál by bylo, kdyby třída Tool byla knihovna a metody by v ní byly statickým kontextem
//v rámci frameworku bych pro předávání Tool instance nepoužíval parametr v konstruktoru, ale použil tzv. Autowired. V případě zájmu můžu zkusit popsat, co to znamená