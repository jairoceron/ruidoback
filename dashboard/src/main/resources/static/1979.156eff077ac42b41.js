"use strict";var w=Object.defineProperty,k=Object.defineProperties,q=Object.getOwnPropertyDescriptors,K=Object.getOwnPropertySymbols,_=Object.prototype.hasOwnProperty,nn=Object.prototype.propertyIsEnumerable,j=(m,f,n)=>f in m?w(m,f,{enumerable:!0,configurable:!0,writable:!0,value:n}):m[f]=n,S=(m,f)=>{for(var n in f||(f={}))_.call(f,n)&&j(m,n,f[n]);if(K)for(var n of K(f))nn.call(f,n)&&j(m,n,f[n]);return m},U=(m,f)=>k(m,q(f));(self.webpackChunkdashboard=self.webpackChunkdashboard||[]).push([[1979],{81979:(m,f,n)=>{n.r(f),n.d(f,{fromUrl:()=>J});var e=n(61921),I=n(40662),t=n(22795),u=n(60305),x=n(89225),D=n(38192),G=n(68325);function J(r){return P.apply(this,arguments)}function P(){return(P=(0,e.Z)(function*(r){var o;const i=null==(o=r.properties)?void 0:o.customParameters,a=yield Q(r.url,i),l=U(S({},r.properties),{url:r.url});if(!a.sublayerIds)return null!=a.layerOrTableId&&(l.layerId=a.layerOrTableId,l.sourceJSON=a.sourceJSON),new a.Constructor(l);const s=new((yield n.e(9871).then(n.bind(n,49871))).default)({title:a.parsedUrl.title});return z(s,a,l),s})).apply(this,arguments)}function W(r,o){return r?r.find(i=>i.id===o):null}function z(r,o,i){function a(l,s){const d=U(S({},i),{layerId:l,sublayerTitleMode:"service-name"});return(0,u.pC)(s)&&(d.sourceJSON=s),new o.Constructor(d)}o.sublayerIds.forEach(l=>{const s=a(l,W(o.sublayerInfos,l));r.add(s)}),o.tableIds.forEach(l=>{const s=a(l,W(o.tableInfos,l));r.tables.add(s)})}function Q(r,o){return O.apply(this,arguments)}function O(){return(O=(0,e.Z)(function*(r,o){let i=(0,D.Qc)(r);if((0,u.Wi)(i)&&(i=yield X(r,o)),(0,u.Wi)(i))throw new t.Z("arcgis-layers:url-mismatch","The url '${url}' is not a valid arcgis resource",{url:r});const{serverType:a,sublayer:l}=i;let s;const d={FeatureServer:"FeatureLayer",StreamServer:"StreamLayer",VectorTileServer:"VectorTileLayer"};switch(a){case"MapServer":s=null!=l?"FeatureLayer":b(r,o).then(y=>y?"TileLayer":"MapImageLayer");break;case"ImageServer":s=v(r,o).then(y=>{const g=y.tileInfo&&y.tileInfo.format;return y.tileInfo?!g||"LERC"!==g.toUpperCase()||y.cacheType&&"elevation"!==y.cacheType.toLowerCase()?"ImageryTileLayer":"ElevationLayer":"ImageryLayer"});break;case"SceneServer":s=v(i.url.path,o).then(y=>{const g={Point:"SceneLayer","3DObject":"SceneLayer",IntegratedMesh:"IntegratedMeshLayer",PointCloud:"PointCloudLayer",Building:"BuildingSceneLayer"};if(y&&Array.isArray(y.layers)&&y.layers.length>0){const A=y.layers[0].layerType;if(null!=g[A])return g[A]}return"SceneLayer"});break;default:s=d[a]}const c="FeatureServer"===a,h={parsedUrl:i,Constructor:null,layerOrTableId:c?l:null,sublayerIds:null,tableIds:null},B=yield s;if({FeatureLayer:!0,SceneLayer:!0}[B]&&null==l){const y=yield $(r,a,o);if(c&&(h.sublayerInfos=y.layerInfos,h.tableInfos=y.tableInfos),y.layerIds.length+y.tableIds.length!==1)h.sublayerIds=y.layerIds,h.tableIds=y.tableIds;else if(c){var N,V;h.layerOrTableId=null!=(N=y.layerIds[0])?N:y.tableIds[0],h.sourceJSON=null!=(V=y.layerInfos[0])?V:y.tableInfos[0]}}return h.Constructor=yield Y(B),h})).apply(this,arguments)}function X(r,o){return T.apply(this,arguments)}function T(){return(T=(0,e.Z)(function*(r,o){var i;const a=yield v(r,o);let l=null,s=null;const d=a.type;if("Feature Layer"===d||"Table"===d?(l="FeatureServer",s=a.id):"indexedVector"===d?l="VectorTileServer":a.hasOwnProperty("mapName")?l="MapServer":a.hasOwnProperty("bandCount")&&a.hasOwnProperty("pixelSizeX")?l="ImageServer":a.hasOwnProperty("maxRecordCount")&&a.hasOwnProperty("allowGeometryUpdates")?l="FeatureServer":a.hasOwnProperty("streamUrls")?l="StreamServer":F(a)?(l="SceneServer",s=a.id):a.hasOwnProperty("layers")&&F(null==(i=a.layers)?void 0:i[0])&&(l="SceneServer"),!l)return null;const L=null!=s?(0,D.DR)(r):null;return{title:(0,u.pC)(L)&&a.name||(0,x.vt)(r),serverType:l,sublayer:s,url:{path:(0,u.pC)(L)?L.serviceUrl:(0,x.mN)(r).path}}})).apply(this,arguments)}function F(r){return(null==r?void 0:r.hasOwnProperty("store"))&&r.hasOwnProperty("id")&&"number"==typeof r.id}function $(r,o,i){return M.apply(this,arguments)}function M(){return(M=(0,e.Z)(function*(r,o,i){var a,l;let s,d=!1;if("FeatureServer"===o){const h=yield H(r,i);d=!!h.layersJSON,s=h.layersJSON||h.serviceJSON}else s=yield v(r,i);const L=null==(a=s)?void 0:a.layers,c=null==(l=s)?void 0:l.tables;return{layerIds:(null==L?void 0:L.map(h=>h.id).reverse())||[],tableIds:(null==c?void 0:c.map(h=>h.id).reverse())||[],layerInfos:d?L:[],tableInfos:d?c:[]}})).apply(this,arguments)}function R(r){return!r.type||"Feature Layer"===r.type}function H(r,o){return Z.apply(this,arguments)}function Z(){return(Z=(0,e.Z)(function*(r,o){var i,a;let l=yield v(r,o);l=l||{},l.layers=(null==(i=l.layers)?void 0:i.filter(R))||[];const s={serviceJSON:l};if(l.currentVersion<10.5)return s;const d=yield v(r+"/layers",o);return s.layersJSON={layers:(null==d||null==(a=d.layers)?void 0:a.filter(R))||[],tables:(null==d?void 0:d.tables)||[]},s})).apply(this,arguments)}function Y(r){return E.apply(this,arguments)}function E(){return(E=(0,e.Z)(function*(r){return(0,G.T[r])()})).apply(this,arguments)}function b(r,o){return p.apply(this,arguments)}function p(){return(p=(0,e.Z)(function*(r,o){return(yield v(r,o)).tileInfo})).apply(this,arguments)}function v(r,o){return C.apply(this,arguments)}function C(){return(C=(0,e.Z)(function*(r,o){return(yield(0,I.default)(r,{responseType:"json",query:S({f:"json"},o)})).data})).apply(this,arguments)}},68325:(m,f,n)=>{n.d(f,{T:()=>I});var e=n(61921);const I={BingMapsLayer:(t=(0,e.Z)(function*(){return(yield n.e(4738).then(n.bind(n,64738))).default}),function(){return t.apply(this,arguments)}),BuildingSceneLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(3055),n.e(8592),n.e(8901)]).then(n.bind(n,78901))).default});return function(){return t.apply(this,arguments)}}(),CSVLayer:function(){var t=(0,e.Z)(function*(){return(yield n.e(7903).then(n.bind(n,67903))).default});return function(){return t.apply(this,arguments)}}(),ElevationLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(8592),n.e(5708)]).then(n.bind(n,5708))).default});return function(){return t.apply(this,arguments)}}(),FeatureLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.resolve().then(n.bind(n,71221))).default});return function(){return t.apply(this,arguments)}}(),GroupLayer:function(){var t=(0,e.Z)(function*(){return(yield n.e(9871).then(n.bind(n,49871))).default});return function(){return t.apply(this,arguments)}}(),GeoRSSLayer:function(){var t=(0,e.Z)(function*(){return(yield n.e(8595).then(n.bind(n,88595))).default});return function(){return t.apply(this,arguments)}}(),ImageryLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(1092),n.e(4786),n.e(5878),n.e(6136)]).then(n.bind(n,76136))).default});return function(){return t.apply(this,arguments)}}(),ImageryTileLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(1092),n.e(4786),n.e(5878),n.e(2791),n.e(8592),n.e(9205)]).then(n.bind(n,99205))).default});return function(){return t.apply(this,arguments)}}(),IntegratedMeshLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(3055),n.e(8592),n.e(8435)]).then(n.bind(n,8435))).default});return function(){return t.apply(this,arguments)}}(),KMLLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(8592),n.e(4252)]).then(n.bind(n,84252))).default});return function(){return t.apply(this,arguments)}}(),MapImageLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(3394),n.e(8592),n.e(9453)]).then(n.bind(n,58382))).default});return function(){return t.apply(this,arguments)}}(),MapNotesLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(8592),n.e(5352)]).then(n.bind(n,15352))).default});return function(){return t.apply(this,arguments)}}(),OGCFeatureLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(8646),n.e(817)]).then(n.bind(n,68020))).default});return function(){return t.apply(this,arguments)}}(),OpenStreetMapLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(8592),n.e(4586)]).then(n.bind(n,84586))).default});return function(){return t.apply(this,arguments)}}(),PointCloudLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(3055),n.e(8592),n.e(1892)]).then(n.bind(n,1892))).default});return function(){return t.apply(this,arguments)}}(),RouteLayer:function(){var t=(0,e.Z)(function*(){return(yield n.e(704).then(n.bind(n,40704))).default});return function(){return t.apply(this,arguments)}}(),SceneLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(3055),n.e(8592),n.e(1252)]).then(n.bind(n,71252))).default});return function(){return t.apply(this,arguments)}}(),StreamLayer:function(){var t=(0,e.Z)(function*(){return(yield n.e(3679).then(n.bind(n,73679))).default});return function(){return t.apply(this,arguments)}}(),TileLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(3394),n.e(8592),n.e(6238)]).then(n.bind(n,14116))).default});return function(){return t.apply(this,arguments)}}(),UnknownLayer:function(){var t=(0,e.Z)(function*(){return(yield n.e(7644).then(n.bind(n,7644))).default});return function(){return t.apply(this,arguments)}}(),UnsupportedLayer:function(){var t=(0,e.Z)(function*(){return(yield n.e(9347).then(n.bind(n,39347))).default});return function(){return t.apply(this,arguments)}}(),VectorTileLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(4945),n.e(8592),n.e(6107)]).then(n.bind(n,24628))).default});return function(){return t.apply(this,arguments)}}(),VoxelLayer:function(){var t=(0,e.Z)(function*(){return(yield n.e(7032).then(n.bind(n,17032))).default});return function(){return t.apply(this,arguments)}}(),WebTileLayer:function(){var t=(0,e.Z)(function*(){return(yield n.e(8592).then(n.bind(n,5575))).default});return function(){return t.apply(this,arguments)}}(),WFSLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(9756),n.e(9675)]).then(n.bind(n,69675))).default});return function(){return t.apply(this,arguments)}}(),WMSLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(8592),n.e(3970)]).then(n.bind(n,53970))).default});return function(){return t.apply(this,arguments)}}(),WMTSLayer:function(){var t=(0,e.Z)(function*(){return(yield Promise.all([n.e(8592),n.e(1125)]).then(n.bind(n,91125))).default});return function(){return t.apply(this,arguments)}}()};var t}}]);