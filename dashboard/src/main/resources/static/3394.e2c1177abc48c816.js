"use strict";var ge=Object.defineProperty,me=Object.defineProperties,De=Object.getOwnPropertyDescriptors,ae=Object.getOwnPropertySymbols,Ie=Object.prototype.hasOwnProperty,Pe=Object.prototype.propertyIsEnumerable,ne=(P,E,t)=>E in P?ge(P,E,{enumerable:!0,configurable:!0,writable:!0,value:t}):P[E]=t,G=(P,E)=>{for(var t in E||(E={}))Ie.call(E,t)&&ne(P,t,E[t]);if(ae)for(var t of ae(E))Pe.call(E,t)&&ne(P,t,E[t]);return P},q=(P,E)=>me(P,De(E));(self.webpackChunkdashboard=self.webpackChunkdashboard||[]).push([[3394],{69106:(P,E,t)=>{t.d(E,{O:()=>F});var I=t(61921),i=t(60046),B=t(40662),K=t(12523),h=t(89225),O=t(25503),f=t(9077),W=(t(67474),t(57025),t(33870),t(67424)),N=t(42442),V=t(82059),$=t(56703),Z=t(99737);const F=x=>{let g=class extends x{constructor(){super(...arguments),this.capabilities=void 0,this.copyright=null,this.fullExtent=null,this.legendEnabled=!0,this.spatialReference=null,this.version=null}readCapabilities(D,d){const n=d.capabilities&&d.capabilities.split(",").map(U=>U.toLowerCase().trim());if(!n)return{operations:{supportsQuery:!1,supportsExportMap:!1,supportsExportTiles:!1,supportsTileMap:!1},exportMap:null,exportTiles:null};const p=this.type,_=-1!==n.indexOf("query"),v=-1!==n.indexOf("map"),M=!!d.exportTilesAllowed,y=-1!==n.indexOf("tilemap"),S="tile"!==p&&!!d.supportsDynamicLayers,Q="tile"!==p&&(!d.tileInfo||S),R="tile"!==p&&(!d.tileInfo||S),C="tile"!==p,J=!!d.cimVersion&&O.G.parse(d.cimVersion).since(1,4);return{operations:{supportsQuery:_,supportsExportMap:v,supportsExportTiles:M,supportsTileMap:y},exportMap:v?{supportsArcadeExpressionForLabeling:J,supportsSublayersChanges:C,supportsDynamicLayers:S,supportsSublayerVisibility:Q,supportsSublayerDefinitionExpression:R}:null,exportTiles:M?{maxExportTilesCount:+d.maxExportTilesCount}:null}}readVersion(D,d){let n=d.currentVersion;return n||(n=d.hasOwnProperty("capabilities")||d.hasOwnProperty("tables")?10:d.hasOwnProperty("supportedImageFormatTypes")?9.31:9.3),n}fetchSublayerInfo(D,d){var n=this;return(0,I.Z)(function*(){return yield n.fetchAllLayersAndTables(d),n._allLayersAndTablesMap.get(D)})()}fetchAllLayersAndTables(D){var d=this;return(0,I.Z)(function*(){yield d.load(D),d._allLayersAndTablesPromise||(d._allLayersAndTablesPromise=(0,B.default)((0,h.mN)(d.url).path+"/layers",{responseType:"json",query:q(G({f:"json"},d.customParameters),{token:d.apiKey})}).then(p=>{d._allLayersAndTablesMap=new Map;for(const _ of p.data.layers)d._allLayersAndTablesMap.set(_.id,_);return{result:p.data}},p=>({error:p})));const n=yield d._allLayersAndTablesPromise;if((0,K.k_)(D),"result"in n)return n.result;throw n.error})()}};return(0,i._)([(0,f.Cb)({readOnly:!0})],g.prototype,"capabilities",void 0),(0,i._)([(0,W.r)("service","capabilities",["capabilities","exportTilesAllowed","maxExportTilesCount","supportsDynamicLayers","tileInfo"])],g.prototype,"readCapabilities",null),(0,i._)([(0,f.Cb)({json:{read:{source:"copyrightText"}}})],g.prototype,"copyright",void 0),(0,i._)([(0,f.Cb)({type:V.Z})],g.prototype,"fullExtent",void 0),(0,i._)([(0,f.Cb)(Z.id)],g.prototype,"id",void 0),(0,i._)([(0,f.Cb)({type:Boolean,json:{origins:{service:{read:{enabled:!1}}},read:{source:"showLegend"},write:{target:"showLegend"}}})],g.prototype,"legendEnabled",void 0),(0,i._)([(0,f.Cb)(Z.C_)],g.prototype,"popupEnabled",void 0),(0,i._)([(0,f.Cb)({type:$.Z})],g.prototype,"spatialReference",void 0),(0,i._)([(0,f.Cb)()],g.prototype,"version",void 0),(0,i._)([(0,W.r)("version",["currentVersion","capabilities","tables","supportedImageFormatTypes"])],g.prototype,"readVersion",null),g=(0,i._)([(0,N.j)("esri.layers.mixins.ArcGISMapService")],g),g}},96108:(P,E,t)=>{t.d(E,{x:()=>g});var I=t(60046),i=t(76011),B=t(49015),K=t(22795),h=t(33870),O=t(9077),m=(t(67474),t(32575)),A=(t(57025),t(42442)),W=t(57722),N=t(95590),V=t(98722);const $=h.Z.getLogger("esri.layers.TileLayer"),F=i.Z.ofType(N.Z);function x(D,d){D&&D.forEach(n=>{d(n),n.sublayers&&n.sublayers.length&&x(n.sublayers,d)})}const g=D=>{let d=class extends D{constructor(...n){super(...n),this.allSublayers=new B.Z({getCollections:()=>[this.sublayers],getChildrenFunction:p=>p.sublayers}),this.sublayersSourceJSON={2:{},3:{},4:{},5:{}},this.handles.add(this.watch("sublayers",(p,_)=>this._handleSublayersChange(p,_),!0))}readSublayers(n,p){if(!p||!n)return;const{sublayersSourceJSON:_}=this,v=(0,W.M9)(p.origin);if(v<2||(_[v]={context:p,visibleLayers:n.visibleLayers||_[v].visibleLayers,layers:n.layers||_[v].layers},v>2))return;this._set("serviceSublayers",this.createSublayersForOrigin("service").sublayers);const{sublayers:M,origin:y}=this.createSublayersForOrigin("web-document"),S=(0,m.vw)(this);S.setDefaultOrigin(y),this._set("sublayers",new F(M)),S.setDefaultOrigin("user")}findSublayerById(n){return this.allSublayers.find(p=>p.id===n)}createServiceSublayers(){return this.createSublayersForOrigin("service").sublayers}createSublayersForOrigin(n){const p=(0,W.M9)("web-document"===n?"web-map":n);let _=2,v=this.sublayersSourceJSON[2].layers,M=this.sublayersSourceJSON[2].context,y=null;const S=[3,4,5].filter(u=>u<=p);for(const u of S){const T=this.sublayersSourceJSON[u];(0,V.ac)(T.layers)&&(_=u,v=T.layers,M=T.context,T.visibleLayers&&(y={visibleLayers:T.visibleLayers,context:T.context}))}const Q=[3,4,5].filter(u=>u>_&&u<=p);let R=null;for(const u of Q){const{layers:T,visibleLayers:H,context:z}=this.sublayersSourceJSON[u];T&&(R={layers:T,context:z}),H&&(y={visibleLayers:H,context:z})}const C=function(D,d){const n=[],p={};return D&&D.forEach(_=>{const v=new N.Z;if(v.read(_,d),p[v.id]=v,null!=_.parentLayerId&&-1!==_.parentLayerId){const M=p[_.parentLayerId];M.sublayers||(M.sublayers=[]),M.sublayers.unshift(v)}else n.unshift(v)}),n}(v,M),J=new Map,U=new Set;if(R)for(const u of R.layers)J.set(u.id,u);if(y)for(const u of y.visibleLayers)U.add(u);return x(C,u=>{R&&u.read(J.get(u.id),R.context),y&&u.read({defaultVisibility:U.has(u.id)},y.context)}),{origin:(0,W.x3)(_),sublayers:new F({items:C})}}read(n,p){super.read(n,p),this.readSublayers(n,p)}_handleSublayersChange(n,p){p&&(p.forEach(_=>{_.parent=null,_.layer=null}),this.handles.remove("sublayers-owner")),n&&(n.forEach(_=>{_.parent=this,_.layer=this}),this.handles.add([n.on("after-add",({item:_})=>{_.parent=this,_.layer=this}),n.on("after-remove",({item:_})=>{_.parent=null,_.layer=null})],"sublayers-owner"),"tile"===this.type&&this.handles.add(n.on("before-changes",_=>{$.error(new K.Z("tilelayer:sublayers-non-modifiable","ISublayer can't be added, moved, or removed from the layer's sublayers",{layer:this})),_.preventDefault()}),"sublayers-owner"))}};return(0,I._)([(0,O.Cb)({readOnly:!0})],d.prototype,"allSublayers",void 0),(0,I._)([(0,O.Cb)({readOnly:!0,type:i.Z.ofType(N.Z)})],d.prototype,"serviceSublayers",void 0),(0,I._)([(0,O.Cb)({value:null,type:F,json:{read:!1,write:{allowNull:!0,ignoreOrigin:!0}}})],d.prototype,"sublayers",void 0),(0,I._)([(0,O.Cb)({readOnly:!0})],d.prototype,"sublayersSourceJSON",void 0),d=(0,I._)([(0,A.j)("esri.layers.mixins.SublayersOwner")],d),d}},95590:(P,E,t)=>{t.d(E,{Z:()=>be});var X,I=t(61921),i=t(60046),K=(t(73513),t(38886)),V=(t(76138),t(45594),t(12205),t(39196),t(32800),t(66771),t(32320),t(38750),t(4075)),$=t(40662),Z=t(90789),F=t(76011),x=t(22795),g=t(10882),D=t(21511),d=t(85071),n=t(14572),p=t(33870),_=t(60305),v=t(71781),M=t(89225),y=t(9077),S=t(32575),Q=t(59559),C=(t(67474),t(67424)),J=t(42442),U=t(43190),u=t(57025),T=t(57722),H=t(25209),z=t(12656),de=t(25808),ye=t(44522),_e=t(23416),ie=t(39417),ee=t(43160),oe=t(57006),pe=t(78710),ue=t(19453),ce=t(82059);function re(e){return e&&"esriSMS"===e.type}function te(e,r,s){var o;const l=this.originIdOf(r)>=(0,T.M9)(s.origin);return{ignoreOrigin:!0,allowNull:l,enabled:!!s&&"map-image"===(null==(o=s.layer)?void 0:o.type)&&(s.writeSublayerStructure||l)}}function le(e,r,s){var o;return{enabled:!!s&&"tile"===(null==(o=s.layer)?void 0:o.type)&&this._isOverridden(r)}}function j(e,r,s){return{ignoreOrigin:!0,enabled:s&&s.writeSublayerStructure||!1}}function Y(e,r,s){return{ignoreOrigin:!0,enabled:!!s&&(s.writeSublayerStructure||this.originIdOf(r)>=(0,T.M9)(s.origin))}}const se=p.Z.getLogger("esri.layers.support.Sublayer");let fe=0;const w=new Set;w.add("layer"),w.add("parent"),w.add("loaded"),w.add("loadStatus"),w.add("loadError"),w.add("loadWarnings");let a=X=class extends((0,g.p)((0,v.R)((0,D.I)(n.Z)))){constructor(e){super(e),this.capabilities=void 0,this.fields=null,this.fullExtent=null,this.globalIdField=null,this.legendEnabled=!0,this.objectIdField=null,this.popupEnabled=!0,this.popupTemplate=null,this.sourceJSON=null,this.title=null,this.typeIdField=null,this.types=null}load(e){var r=this;return(0,I.Z)(function*(){return r.addResolvingPromise((0,I.Z)(function*(){var s;if(!r.layer&&!r.url)throw new x.Z("sublayer:missing-layer","Sublayer can't be loaded without being part of a layer",{sublayer:r});let o=null;if(!r.layer||r.originIdOf("url")>2||"data-layer"===(null==(s=r.source)?void 0:s.type))o=(yield(0,$.default)(r.url,G({responseType:"json",query:{f:"json"}},e))).data;else{var l;let c=r.id;"map-layer"===(null==(l=r.source)?void 0:l.type)&&(c=r.source.mapLayerId),o=yield r.layer.fetchSublayerInfo(c,e)}o&&(r.sourceJSON=o,r.read({layerDefinition:o},{origin:"service"}))})()),r})()}readCapabilities(e,r){const s=(e=(r=r.layerDefinition||r).capabilities||e)?e.toLowerCase().split(",").map(o=>o.trim()):[];return{exportMap:{supportsModification:!!r.canModifyLayer},operations:{supportsQuery:-1!==s.indexOf("query")}}}set definitionExpression(e){this._setAndNotifyLayer("definitionExpression",e)}get fieldsIndex(){return new de.Z(this.fields||[])}set floorInfo(e){this._setAndNotifyLayer("floorInfo",e)}readGlobalIdFieldFromService(e,r){if((r=r.layerDefinition||r).globalIdField)return r.globalIdField;if(r.fields)for(const s of r.fields)if("esriFieldTypeGlobalID"===s.type)return s.name}get id(){const e=this._get("id");return null==e?fe++:e}set id(e){this._get("id")!==e&&(!1!==this.get("layer.capabilities.exportMap.supportsDynamicLayers")?this._set("id",e):this._logLockedError("id","capability not available 'layer.capabilities.exportMap.supportsDynamicLayers'"))}set labelingInfo(e){this._setAndNotifyLayer("labelingInfo",e)}writeLabelingInfo(e,r,s,o){e&&e.length&&(r.layerDefinition={drawingInfo:{labelingInfo:e.map(l=>l.write({},o))}})}set labelsVisible(e){this._setAndNotifyLayer("labelsVisible",e)}set layer(e){this._set("layer",e),this.sublayers&&this.sublayers.forEach(r=>r.layer=e)}set listMode(e){this._set("listMode",e)}set minScale(e){this._setAndNotifyLayer("minScale",e)}readMinScale(e,r){return r.minScale||r.layerDefinition&&r.layerDefinition.minScale||0}set maxScale(e){this._setAndNotifyLayer("maxScale",e)}readMaxScale(e,r){return r.maxScale||r.layerDefinition&&r.layerDefinition.maxScale||0}readObjectIdFieldFromService(e,r){if((r=r.layerDefinition||r).objectIdField)return r.objectIdField;if(r.fields)for(const s of r.fields)if("esriFieldTypeOID"===s.type)return s.name}set opacity(e){this._setAndNotifyLayer("opacity",e)}readOpacity(e,r){const s=r.layerDefinition;return 1-.01*(null!=s.transparency?s.transparency:s.drawingInfo.transparency)}writeOpacity(e,r,s,o){r.layerDefinition={drawingInfo:{transparency:100-100*e}}}writeParent(e,r){r.parentLayerId=this.parent&&this.parent!==this.layer?(0,u.vU)(this.parent.id):-1}get defaultPopupTemplate(){return this.createPopupTemplate()}set renderer(e){if(e)for(const r of e.getSymbols())if((0,Z.dU)(r)){se.warn("Sublayer renderer should use 2D symbols");break}this._setAndNotifyLayer("renderer",e)}get source(){return this._get("source")||new ee.R({mapLayerId:this.id})}set source(e){this._setAndNotifyLayer("source",e)}set sublayers(e){this._handleSublayersChange(e,this._get("sublayers")),this._set("sublayers",e)}castSublayers(e){return(0,u.se)(F.Z.ofType(X),e)}writeSublayers(e,r,s){this.get("sublayers.length")&&(r[s]=this.sublayers.map(o=>o.id).toArray().reverse())}readTypeIdField(e,r){let s=(r=r.layerDefinition||r).typeIdField;if(s&&r.fields){s=s.toLowerCase();const o=r.fields.find(l=>l.name.toLowerCase()===s);o&&(s=o.name)}return null}get url(){var e,r;const s=null!=(e=null==(r=this.layer)?void 0:r.parsedUrl)?e:this._lastParsedUrl,o=this.source;if(!s)return null;if(this._lastParsedUrl=s,"map-layer"===(null==o?void 0:o.type))return`${s.path}/${o.mapLayerId}`;const l={layer:JSON.stringify({source:this.source})};return`${s.path}/dynamicLayer?${(0,M.B7)(l)}`}set url(e){e?this._override("url",e):this._clearOverride("url")}set visible(e){this._setAndNotifyLayer("visible",e)}writeVisible(e,r,s,o){r[s]=this.getAtOrigin("defaultVisibility","service")||e}clone(){const{store:e}=(0,S.vw)(this),r=new X;return(0,S.vw)(r).store=e.clone(w),this.commitProperty("url"),r._lastParsedUrl=this._lastParsedUrl,r}createPopupTemplate(e){return(0,pe.eZ)(this,e)}createQuery(){return new oe.Z({returnGeometry:!0,where:this.definitionExpression||"1=1"})}createFeatureLayer(){var e=this;return(0,I.Z)(function*(){var r,s;if(e.hasOwnProperty("sublayers"))return null;const o=null==(r=e.layer)?void 0:r.parsedUrl,l=new((yield Promise.resolve().then(t.bind(t,71221))).default)({url:o.path});return o&&e.source&&("map-layer"===e.source.type?l.layerId=e.source.mapLayerId:l.dynamicDataSource=e.source),null!=e.layer.refreshInterval&&(l.refreshInterval=e.layer.refreshInterval),e.definitionExpression&&(l.definitionExpression=e.definitionExpression),e.floorInfo&&(l.floorInfo=(0,d.d9)(e.floorInfo)),e.originIdOf("labelingInfo")>2&&(l.labelingInfo=(0,d.d9)(e.labelingInfo)),e.originIdOf("labelsVisible")>0&&(l.labelsVisible=e.labelsVisible),e.originIdOf("legendEnabled")>0&&(l.legendEnabled=e.legendEnabled),e.originIdOf("visible")>0&&(l.visible=e.visible),e.originIdOf("minScale")>0&&(l.minScale=e.minScale),e.originIdOf("maxScale")>0&&(l.maxScale=e.maxScale),e.originIdOf("opacity")>0&&(l.opacity=e.opacity),e.originIdOf("popupTemplate")>0&&(l.popupTemplate=(0,d.d9)(e.popupTemplate)),e.originIdOf("renderer")>2&&(l.renderer=(0,d.d9)(e.renderer)),"data-layer"===(null==(s=e.source)?void 0:s.type)&&(l.dynamicDataSource=e.source.clone()),e.originIdOf("title")>0&&(l.title=e.title),"map-image"===e.layer.type&&e.layer.originIdOf("customParameters")>0&&(l.customParameters=e.layer.customParameters),"tile"===e.layer.type&&e.layer.originIdOf("customParameters")>0&&(l.customParameters=e.layer.customParameters),l})()}getField(e){return this.fieldsIndex.get(e)}getFeatureType(e){const{typeIdField:r,types:s}=this;if(!r||!e)return null;const o=e.attributes?e.attributes[r]:void 0;if(null==o)return null;let l=null;return s.some(c=>{const{id:L}=c;return null!=L&&(L.toString()===o.toString()&&(l=c),!!l)}),l}getFieldDomain(e,r){const o=this.getFeatureType(r&&r.feature);if(o){const l=o.domains&&o.domains[e];if(l&&"inherited"!==l.type)return l}return this._getLayerDomain(e)}queryFeatures(e=this.createQuery(),r){var s=this;return(0,I.Z)(function*(){var o,l,c,L;if(yield s.load(),!s.get("capabilities.operations.supportsQuery"))throw new x.Z("Sublayer.queryFeatures","this layer doesn't support queries.");const[{executeQuery:Ee},{default:he}]=yield Promise.all([Promise.resolve().then(t.bind(t,85411)),Promise.resolve().then(t.bind(t,51201))]),ve=yield Ee(s.url,oe.Z.from(e),null!=(o=null==(l=s.layer)?void 0:l.spatialReference)?o:null,q(G({},r),{query:q(G({},null==(c=s.layer)?void 0:c.customParameters),{token:null==(L=s.layer)?void 0:L.apiKey})})),k=he.fromJSON(ve.data);if(null!=k&&k.features)for(const Oe of k.features)Oe.sourceLayer=s;return k})()}toExportImageJSON(e){var r;const s={id:this.id,source:(null==(r=this.source)?void 0:r.toJSON())||{mapLayerId:this.id,type:"mapLayer"}};if(this.definitionExpression){const c=(0,_.pC)(e)?(0,ue.Hp)(e,this):this.definitionExpression;s.definitionExpression=c}else(0,_.pC)(e)&&(s.definitionExpression=e);const o=["renderer","labelingInfo","opacity","labelsVisible"].reduce((c,L)=>(c[L]=this.originIdOf(L),c),{});if(Object.keys(o).some(c=>o[c]>2)){const c=s.drawingInfo={};o.renderer>2&&(c.renderer=this.renderer?this.renderer.toJSON():null),o.labelsVisible>2&&(c.showLabels=this.labelsVisible),this.labelsVisible&&o.labelingInfo>2&&(c.labelingInfo=this.labelingInfo?this.labelingInfo.map(L=>L.write({},{origin:"service",layer:this.layer})):null,c.showLabels=!0),o.opacity>2&&(c.transparency=100-100*this.opacity),this._assignDefaultSymbolColors(c.renderer)}return s}_assignDefaultSymbolColors(e){this._forEachSimpleMarkerSymbols(e,r=>{r.color||"esriSMSX"!==r.style&&"esriSMSCross"!==r.style||(r.color=r.outline&&r.outline.color?r.outline.color:[0,0,0,0])})}_forEachSimpleMarkerSymbols(e,r){if(e){const s="uniqueValueInfos"in e?e.uniqueValueInfos:"classBreakInfos"in e?e.classBreakInfos:[];for(const o of s)re(o.symbol)&&r(o.symbol);"symbol"in e&&re(e.symbol)&&r(e.symbol),"defaultSymbol"in e&&re(e.defaultSymbol)&&r(e.defaultSymbol)}}_setAndNotifyLayer(e,r){const s=this.layer,o=this._get(e);let l,c;switch(e){case"definitionExpression":case"floorInfo":l="supportsSublayerDefinitionExpression";case"minScale":case"maxScale":case"visible":l="supportsSublayerVisibility";break;case"labelingInfo":case"labelsVisible":case"opacity":case"renderer":case"source":l="supportsDynamicLayers",c="supportsModification"}const L=(0,S.vw)(this).getDefaultOrigin();if("service"!==L){if(l&&!1===this.get(`layer.capabilities.exportMap.${l}`))return void this._logLockedError(e,`capability not available 'layer.capabilities.exportMap.${l}'`);if(c&&!1===this.get(`capabilities.exportMap.${c}`))return void this._logLockedError(e,`capability not available 'capabilities.exportMap.${c}'`)}"source"!==e||"not-loaded"===this.loadStatus?(this._set(e,r),"service"!==L&&o!==r&&s&&s.emit&&s.emit("sublayer-update",{propertyName:e,target:this})):this._logLockedError(e,"'source' can't be changed after calling sublayer.load()")}_handleSublayersChange(e,r){r&&(r.forEach(s=>{s.parent=null,s.layer=null}),this.handles.removeAll()),e&&(e.forEach(s=>{s.parent=this,s.layer=this.layer}),this.handles.add([e.on("after-add",({item:s})=>{s.parent=this,s.layer=this.layer}),e.on("after-remove",({item:s})=>{s.parent=null,s.layer=null}),e.on("before-changes",s=>{const o=this.get("layer.capabilities.exportMap.supportsSublayersChanges");null==o||o||(se.error(new x.Z("sublayer:sublayers-non-modifiable","Sublayer can't be added, moved, or removed from the layer's sublayers",{sublayer:this,layer:this.layer})),s.preventDefault())})]))}_logLockedError(e,r){se.error(new x.Z("sublayer:locked",`Property '${e}' can't be changed on Sublayer from the layer '${this.layer.id}'`,{reason:r,sublayer:this,layer:this.layer}))}_getLayerDomain(e){const r=this.fieldsIndex.get(e);return r?r.domain:null}};a.test={isMapImageLayerOverridePolicy:e=>e===j||e===te,isTileImageLayerOverridePolicy:e=>e===le},(0,i._)([(0,y.Cb)({readOnly:!0})],a.prototype,"capabilities",void 0),(0,i._)([(0,C.r)("service","capabilities",["layerDefinition.canModifyLayer","layerDefinition.capabilities"])],a.prototype,"readCapabilities",null),(0,i._)([(0,y.Cb)({type:String,value:null,json:{name:"layerDefinition.definitionExpression",write:{overridePolicy:te}}})],a.prototype,"definitionExpression",null),(0,i._)([(0,y.Cb)({type:[z.Z],json:{origins:{service:{read:{source:"layerDefinition.fields"}}}}})],a.prototype,"fields",void 0),(0,i._)([(0,y.Cb)({readOnly:!0})],a.prototype,"fieldsIndex",null),(0,i._)([(0,y.Cb)({type:_e.Z,value:null,json:{name:"layerDefinition.floorInfo",read:{source:"layerDefinition.floorInfo"},write:{target:"layerDefinition.floorInfo",overridePolicy:te},origins:{"web-scene":{read:!1,write:!1}}}})],a.prototype,"floorInfo",null),(0,i._)([(0,y.Cb)({type:ce.Z,json:{read:{source:"layerDefinition.extent"}}})],a.prototype,"fullExtent",void 0),(0,i._)([(0,y.Cb)({type:String})],a.prototype,"globalIdField",void 0),(0,i._)([(0,C.r)("service","globalIdField",["layerDefinition.globalIdField","layerDefinition.fields"])],a.prototype,"readGlobalIdFieldFromService",null),(0,i._)([(0,y.Cb)({type:u.z8,json:{write:{ignoreOrigin:!0}}})],a.prototype,"id",null),(0,i._)([(0,y.Cb)({value:null,type:[ye.Z],json:{read:{source:"layerDefinition.drawingInfo.labelingInfo"},write:{target:"layerDefinition.drawingInfo.labelingInfo",overridePolicy:j}}})],a.prototype,"labelingInfo",null),(0,i._)([(0,U.c)("labelingInfo")],a.prototype,"writeLabelingInfo",null),(0,i._)([(0,y.Cb)({type:Boolean,value:!0,json:{read:{source:"layerDefinition.drawingInfo.showLabels"},write:{target:"layerDefinition.drawingInfo.showLabels",overridePolicy:j}}})],a.prototype,"labelsVisible",null),(0,i._)([(0,y.Cb)({value:null})],a.prototype,"layer",null),(0,i._)([(0,y.Cb)({type:Boolean,value:!0,json:{origins:{service:{read:{enabled:!1}}},read:{source:"showLegend"},write:{target:"showLegend",overridePolicy:Y}}})],a.prototype,"legendEnabled",void 0),(0,i._)([(0,y.Cb)({type:["show","hide","hide-children"],value:"show",json:{read:!1,write:!1,origins:{"web-scene":{read:!0,write:!0}}}})],a.prototype,"listMode",null),(0,i._)([(0,y.Cb)({type:Number,value:0,json:{write:{overridePolicy:j}}})],a.prototype,"minScale",null),(0,i._)([(0,C.r)("minScale",["minScale","layerDefinition.minScale"])],a.prototype,"readMinScale",null),(0,i._)([(0,y.Cb)({type:Number,value:0,json:{write:{overridePolicy:j}}})],a.prototype,"maxScale",null),(0,i._)([(0,C.r)("maxScale",["maxScale","layerDefinition.maxScale"])],a.prototype,"readMaxScale",null),(0,i._)([(0,y.Cb)({type:String})],a.prototype,"objectIdField",void 0),(0,i._)([(0,C.r)("service","objectIdField",["layerDefinition.objectIdField","layerDefinition.fields"])],a.prototype,"readObjectIdFieldFromService",null),(0,i._)([(0,y.Cb)({type:Number,value:1,json:{write:{target:"layerDefinition.drawingInfo.transparency",overridePolicy:j}}})],a.prototype,"opacity",null),(0,i._)([(0,C.r)("opacity",["layerDefinition.drawingInfo.transparency","layerDefinition.transparency"])],a.prototype,"readOpacity",null),(0,i._)([(0,U.c)("opacity")],a.prototype,"writeOpacity",null),(0,i._)([(0,y.Cb)({json:{type:u.z8,write:{target:"parentLayerId",allowNull:!0,overridePolicy:j}}})],a.prototype,"parent",void 0),(0,i._)([(0,U.c)("parent")],a.prototype,"writeParent",null),(0,i._)([(0,y.Cb)({type:Boolean,value:!0,json:{read:{source:"disablePopup",reader:(e,r)=>!r.disablePopup},write:{target:"disablePopup",overridePolicy:Y,writer(e,r,s){r[s]=!e}}}})],a.prototype,"popupEnabled",void 0),(0,i._)([(0,y.Cb)({type:K.Z,json:{read:{source:"popupInfo"},write:{target:"popupInfo",overridePolicy:Y}}})],a.prototype,"popupTemplate",void 0),(0,i._)([(0,y.Cb)({readOnly:!0})],a.prototype,"defaultPopupTemplate",null),(0,i._)([(0,y.Cb)({types:V.A,value:null,json:{name:"layerDefinition.drawingInfo.renderer",write:{overridePolicy:j},origins:{"web-scene":{types:V.o,name:"layerDefinition.drawingInfo.renderer",write:{overridePolicy:j}}}}})],a.prototype,"renderer",null),(0,i._)([(0,y.Cb)({types:{key:"type",base:null,typeMap:{"data-layer":ie.n,"map-layer":ee.R}},cast(e){if(e){if("mapLayerId"in e)return(0,u.TJ)(ee.R,e);if("dataSource"in e)return(0,u.TJ)(ie.n,e)}return e},json:{name:"layerDefinition.source",write:{overridePolicy:j}}})],a.prototype,"source",null),(0,i._)([(0,y.Cb)()],a.prototype,"sourceJSON",void 0),(0,i._)([(0,y.Cb)({value:null,json:{type:[u.z8],write:{target:"subLayerIds",allowNull:!0,overridePolicy:j}}})],a.prototype,"sublayers",null),(0,i._)([(0,Q.p)("sublayers")],a.prototype,"castSublayers",null),(0,i._)([(0,U.c)("sublayers")],a.prototype,"writeSublayers",null),(0,i._)([(0,y.Cb)({type:String,json:{read:{source:"name"},write:{target:"name",allowNull:!0,overridePolicy:Y}}})],a.prototype,"title",void 0),(0,i._)([(0,y.Cb)({type:String})],a.prototype,"typeIdField",void 0),(0,i._)([(0,C.r)("typeIdField",["layerDefinition.typeIdField"])],a.prototype,"readTypeIdField",null),(0,i._)([(0,y.Cb)({type:[H.Z],json:{origins:{service:{read:{source:"layerDefinition.types"}}}}})],a.prototype,"types",void 0),(0,i._)([(0,y.Cb)({type:String,json:{read:{source:"layerUrl"},write:{target:"layerUrl",overridePolicy:le}}})],a.prototype,"url",null),(0,i._)([(0,y.Cb)({type:Boolean,value:!0,json:{read:{source:"defaultVisibility"},write:{target:"defaultVisibility",overridePolicy:j}}})],a.prototype,"visible",null),(0,i._)([(0,U.c)("visible")],a.prototype,"writeVisible",null),a=X=(0,i._)([(0,J.j)("esri.layers.support.Sublayer")],a);var be=a},98722:(P,E,t)=>{function I(h,O,f){return O.flatten(({sublayers:b})=>b).length!==h.length||!!h.some(b=>b.originIdOf("minScale")>f||b.originIdOf("maxScale")>f||b.originIdOf("renderer")>f||b.originIdOf("labelingInfo")>f||b.originIdOf("opacity")>f||b.originIdOf("labelsVisible")>f||b.originIdOf("source")>f)||!B(h,O)}function i(h,O,f){return!!h.some(m=>{const b=m.source;return!(!b||"map-layer"===b.type&&b.mapLayerId===m.id&&(!b.gdbVersion||b.gdbVersion===f.gdbVersion))||m.originIdOf("renderer")>2||m.originIdOf("labelingInfo")>2||m.originIdOf("opacity")>2||m.originIdOf("labelsVisible")>2})||!B(h,O)}function B(h,O){if(!h||!h.length)return!0;const f=O.slice().reverse().flatten(({sublayers:A})=>A&&A.toArray().reverse()).map(A=>A.id).toArray();if(h.length>f.length)return!1;let m=0;const b=f.length;for(const{id:A}of h){for(;m<b&&f[m]!==A;)m++;if(m>=b)return!1}return!0}function K(h){return!!h&&h.some(O=>null!=O.minScale||O.layerDefinition&&null!=O.layerDefinition.minScale)}t.d(E,{FN:()=>i,ac:()=>K,QV:()=>I})}}]);