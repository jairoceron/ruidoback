"use strict";var X=Object.defineProperty,x=Object.getOwnPropertySymbols,Y=Object.prototype.hasOwnProperty,$=Object.prototype.propertyIsEnumerable,O=(u,y,e)=>y in u?X(u,y,{enumerable:!0,configurable:!0,writable:!0,value:e}):u[y]=e,F=(u,y)=>{for(var e in y||(y={}))Y.call(y,e)&&O(u,e,y[e]);if(x)for(var e of x(y))$.call(y,e)&&O(u,e,y[e]);return u};(self.webpackChunkdashboard=self.webpackChunkdashboard||[]).push([[4252],{84252:(u,y,e)=>{e.r(y),e.d(y,{default:()=>D});var d,j=e(61921),r=e(60046),p=(e(73513),e(76011)),M=e(49015),c=e(60305),Z=e(71781),R=e(12523),N=e(89225),i=e(9077),C=(e(67474),e(57025)),b=(e(33870),e(67424)),g=e(42442),I=e(43190),S=e(56703),P=e(21611),T=e(64469),J=e(24065),K=e(52043),H=e(44660),U=e(55130),z=e(99737),A=e(77624),W=e(54792),G=e(14572),Q=e(9171),m=e(97467),V=e(59559),h=e(44564),f=e(82059);let n=d=class extends(A.Z.EventedMixin((0,W.eC)(G.Z))){constructor(){super(...arguments),this._sublayersHandles=null,this.description=null,this.id=null,this.networkLink=null,this.title=null,this.sourceJSON=null,this.fullExtent=null}initialize(){(0,m.N1)(this,"networkLink").then(()=>(0,m.LR)(this,"visible")).then(()=>this.load())}load(t){if(!this.networkLink||this.networkLink.viewFormat)return;const s=(0,c.pC)(t)?t.signal:null,l=this._fetchService(this._get("networkLink").href,s).then(o=>{const v=(0,h.lm)(o.sublayers);this.fullExtent=f.Z.fromJSON(v),this.sourceJSON=o;const L=(0,C.se)(p.Z.ofType(d),(0,h.j5)(d,o));this.sublayers?this.sublayers.addMany(L):this.sublayers=L,this.layer.emit("sublayer-update"),this.layer&&this.layer.notifyChange("visibleSublayers")});return this.addResolvingPromise(l),Promise.resolve(this)}set sublayers(t){const s=this._get("sublayers");s&&(s.forEach(l=>{l.parent=null,l.layer=null}),this._sublayersHandles.forEach(l=>l.remove()),this._sublayersHandles=null),t&&(t.forEach(l=>{l.parent=this,l.layer=this.layer}),this._sublayersHandles=[t.on("after-add",({item:l})=>{l.parent=this,l.layer=this.layer}),t.on("after-remove",({item:l})=>{l.parent=null,l.layer=null})]),this._set("sublayers",t)}castSublayers(t){return(0,C.se)(p.Z.ofType(d),t)}get visible(){return this._get("visible")}set visible(t){this._get("visible")!==t&&(this._set("visible",t),this.layer&&this.layer.notifyChange("visibleSublayers"))}readVisible(t,s){return!!s.visibility}set layer(t){this._set("layer",t),this.sublayers&&this.sublayers.forEach(s=>s.layer=t)}_fetchService(t,s){return(0,h.CS)(t,this.layer.outSpatialReference,this.layer.refreshInterval,s).then(l=>(0,h.Cw)(l.data))}};(0,r._)([(0,i.Cb)()],n.prototype,"description",void 0),(0,r._)([(0,i.Cb)()],n.prototype,"id",void 0),(0,r._)([(0,i.Cb)({readOnly:!0,value:null})],n.prototype,"networkLink",void 0),(0,r._)([(0,i.Cb)({json:{write:{allowNull:!0}}})],n.prototype,"parent",void 0),(0,r._)([(0,i.Cb)({value:null,json:{write:{allowNull:!0}}})],n.prototype,"sublayers",null),(0,r._)([(0,V.p)("sublayers")],n.prototype,"castSublayers",null),(0,r._)([(0,i.Cb)({value:null,json:{read:{source:"name",reader:t=>(0,Q.Cb)(t)}}})],n.prototype,"title",void 0),(0,r._)([(0,i.Cb)({value:!0})],n.prototype,"visible",null),(0,r._)([(0,b.r)("visible",["visibility"])],n.prototype,"readVisible",null),(0,r._)([(0,i.Cb)()],n.prototype,"sourceJSON",void 0),(0,r._)([(0,i.Cb)({value:null})],n.prototype,"layer",null),(0,r._)([(0,i.Cb)({type:f.Z})],n.prototype,"fullExtent",void 0),n=d=(0,r._)([(0,g.j)("esri.layers.support.KMLSublayer")],n);var E=n;const B=["kml","xml"];let a=class extends((0,T.h)((0,H.Q)((0,U.M)((0,J.q)((0,K.I)((0,Z.R)(P.Z))))))){constructor(...t){super(...t),this._visibleFolders=[],this.allSublayers=new M.Z({getCollections:()=>[this.sublayers],getChildrenFunction:s=>s.sublayers}),this.outSpatialReference=S.Z.WGS84,this.path=null,this.legendEnabled=!1,this.operationalLayerType="KML",this.sublayers=null,this.type="kml",this.url=null}initialize(){this.watch("sublayers",(t,s)=>{s&&s.forEach(l=>{l.parent=null,l.layer=null}),t&&t.forEach(l=>{l.parent=this,l.layer=this})},!0),this.on("sublayer-update",()=>this.notifyChange("fullExtent"))}normalizeCtorArgs(t,s){return"string"==typeof t?F({url:t},s):t}readSublayersFromItemOrWebMap(t,s){this._visibleFolders=s.visibleFolders}readSublayers(t,s,l){return(0,h.j5)(E,s,l,this._visibleFolders)}writeSublayers(t,s){const l=[],o=t.toArray();for(;o.length;){const v=o[0];v.networkLink||(v.visible&&l.push(v.id),v.sublayers&&o.push(...v.sublayers.toArray())),o.shift()}s.visibleFolders=l}get title(){const t=this._get("title");return t&&"defaults"!==this.originOf("title")?t:this.url?(0,N.vt)(this.url,B)||"KML":t||""}set title(t){this._set("title",t)}get visibleSublayers(){const t=this.sublayers,s=[],l=o=>{o.visible&&(s.push(o),o.sublayers&&o.sublayers.forEach(l))};return t&&t.forEach(l),s}get fullExtent(){return this._recomputeFullExtent()}load(t){const s=(0,c.pC)(t)?t.signal:null;return this.addResolvingPromise(this.loadFromPortal({supportedTypes:["KML"]},t).catch(R.r9).then(()=>this._fetchService(s))),Promise.resolve(this)}destroy(){super.destroy(),this.allSublayers.destroy()}_fetchService(t){var s=this;return(0,j.Z)(function*(){const l=yield Promise.resolve().then(()=>s.resourceInfo?{ssl:!1,data:s.resourceInfo}:(0,h.CS)(s.url,s.outSpatialReference,s.refreshInterval,t)),o=(0,h.Cw)(l.data);o&&s.read(o,{origin:"service"})})()}_recomputeFullExtent(){let t=null;this.extent&&(t=this.extent.clone());const s=l=>{if(l.sublayers)for(const o of l.sublayers.items)s(o),o.visible&&o.fullExtent&&(t?t.union(o.fullExtent):t=o.fullExtent.clone())};return s(this),t}};(0,r._)([(0,i.Cb)({readOnly:!0})],a.prototype,"allSublayers",void 0),(0,r._)([(0,i.Cb)({type:S.Z})],a.prototype,"outSpatialReference",void 0),(0,r._)([(0,i.Cb)({type:String,json:{origins:{"web-scene":{read:!0,write:!0}},read:!1}})],a.prototype,"path",void 0),(0,r._)([(0,i.Cb)({readOnly:!0,json:{read:!1,write:!1}})],a.prototype,"legendEnabled",void 0),(0,r._)([(0,i.Cb)({type:["show","hide","hide-children"]})],a.prototype,"listMode",void 0),(0,r._)([(0,i.Cb)({type:["KML"]})],a.prototype,"operationalLayerType",void 0),(0,r._)([(0,i.Cb)({})],a.prototype,"resourceInfo",void 0),(0,r._)([(0,i.Cb)({type:p.Z.ofType(E),json:{write:{ignoreOrigin:!0}}})],a.prototype,"sublayers",void 0),(0,r._)([(0,b.r)(["web-map","portal-item"],"sublayers",["visibleFolders"])],a.prototype,"readSublayersFromItemOrWebMap",null),(0,r._)([(0,b.r)("service","sublayers",["sublayers"])],a.prototype,"readSublayers",null),(0,r._)([(0,I.c)("sublayers")],a.prototype,"writeSublayers",null),(0,r._)([(0,i.Cb)({readOnly:!0,json:{read:!1}})],a.prototype,"type",void 0),(0,r._)([(0,i.Cb)({json:{origins:{"web-map":{read:{source:"title"}}},write:{ignoreOrigin:!0}}})],a.prototype,"title",null),(0,r._)([(0,i.Cb)(z.HQ)],a.prototype,"url",void 0),(0,r._)([(0,i.Cb)({readOnly:!0})],a.prototype,"visibleSublayers",null),(0,r._)([(0,i.Cb)({type:f.Z})],a.prototype,"extent",void 0),(0,r._)([(0,i.Cb)()],a.prototype,"fullExtent",null),a=(0,r._)([(0,g.j)("esri.layers.KMLLayer")],a);var D=a}}]);