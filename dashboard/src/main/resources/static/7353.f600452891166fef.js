"use strict";(self.webpackChunkdashboard=self.webpackChunkdashboard||[]).push([[7353],{62008:(z,R,l)=>{function d(s,a){return a?"xoffset"in a&&a.xoffset?Math.max(s,Math.abs(a.xoffset)):"yoffset"in a&&a.yoffset?Math.max(s,Math.abs(a.yoffset||0)):s:s}function w(s,a){return"number"==typeof s?s:s&&s.stops&&s.stops.length?function(s){let a=0,h=0;for(let c=0;c<s.length;c++){const o=s[c].size;"number"==typeof o&&(a+=o,h++)}return a/h}(s.stops):a}function x(s){const a=s&&s.renderer,h="touch"===(s&&s.event&&s.event.pointerType)?9:6;if(!a)return h;const c="visualVariables"in a?function(s,a){if(!a)return s;const h=a.filter(m=>"size"===m.type).map(m=>{const{maxSize:E,minSize:P}=m;return(w(E,s)+w(P,s))/2});let c=0;const o=h.length;if(0===o)return s;for(let m=0;m<o;m++)c+=h[m];const f=Math.floor(c/o);return Math.max(f,s)}(h,a.visualVariables):h;if("simple"===a.type)return d(c,a.symbol);if("unique-value"===a.type){let o=c;return a.uniqueValueInfos.forEach(f=>{o=d(o,f.symbol)}),o}if("class-breaks"===a.type){let o=c;return a.classBreakInfos.forEach(f=>{o=d(o,f.symbol)}),o}return c}l.d(R,{k:()=>x})},87353:(z,R,l)=>{l.r(R),l.d(R,{default:()=>W});var d=l(61921),V=l(60046),w=l(22795),C=l(33870),x=l(60305),s=l(12523),a=l(9077),o=(l(67474),l(57025),l(42442)),f=l(61793),m=l(70297),E=l(54231),P=l(6525),U=l(71079),Z=l(59868),F=l(59989),b=l(72619),S=l(62008);const O=e=>{let i=class extends e{fetchPopupFeatures(r,M){var g=this;return(0,d.Z)(function*(){const{layer:v}=g;if(!r)return Promise.reject(new w.Z("tilelayerview:fetchPopupFeatures","Nothing to fetch without area",{layer:v}));if("tile"!==v.type)return Promise.reject(new w.Z("tilelayerview:fetchPopupFeatures","Layer type should be 'tile'",{type:v.type}));const I=g.get("view.scale"),T=v.allSublayers.toArray().filter(u=>u.popupTemplate&&u.popupEnabled&&u.visible&&(0===u.minScale||I<=u.minScale)&&(0===u.maxScale||I>=u.maxScale));return(0,s.as)(T.map(function(){var u=(0,d.Z)(function*(p){const y=p.createQuery(),L=(0,x.pC)(M)?M.event:null,Q=(0,S.k)({renderer:p.renderer,event:L});return y.geometry=g.createFetchPopupFeaturesQueryGeometry(r,Q),y.outFields=yield p.popupTemplate.getRequiredFields(),(yield p.queryFeatures(y)).features});return function(p){return u.apply(this,arguments)}}())).then(u=>[].concat(...u.map(p=>p.value).filter(Boolean)))})()}};return(0,V._)([(0,a.Cb)()],i.prototype,"layer",void 0),i=(0,V._)([(0,o.j)("esri.layers.mixins.TileLayerView")],i),i};var j=l(16204);const A=C.Z.getLogger("esri.views.2d.layers.TileLayerView2D"),K=[0,0];let D=class extends(O((0,b.y)((0,f.Y)((0,m.y)(F.Z))))){constructor(){super(...arguments),this._tileStrategy=null,this._fetchQueue=null,this.layer=null}initialize(){const e=this.layer.tileInfo,i=e&&e.spatialReference;let r;i||(r=new w.Z("layerview:tiling-information-missing","The layer doesn't provide tiling information",{layer:this.layer})),i.equals(this.view.spatialReference)||(r=new w.Z("layerview:spatial-reference-incompatible","The spatial reference of this layer does not meet the requirements of the view",{layer:this.layer})),this.watch("resampling",()=>{this.doRefresh()}),r&&this.addResolvingPromise(Promise.reject(r))}get resampling(){return!("resampling"in this.layer)||!1!==this.layer.resampling}hitTest(){return null}update(e){this._fetchQueue.pause(),this._fetchQueue.state=e.state,this._tileStrategy.update(e),this._fetchQueue.resume(),this.notifyChange("updating")}attach(){const e="tileServers"in this.layer?this.layer.tileServers:null;this._tileInfoView=new E.Z(this.layer.tileInfo,this.layer.fullExtent),this._fetchQueue=new U.Z({tileInfoView:this._tileInfoView,concurrency:e&&10*e.length||10,process:(i,r)=>this.fetchTile(i,r)}),this._tileStrategy=new Z.Z({cachePolicy:"keep",resampling:this.resampling,acquireTile:i=>this.acquireTile(i),releaseTile:i=>this.releaseTile(i),tileInfoView:this._tileInfoView}),this.requestUpdate(),this.container.requestRender(),super.attach()}detach(){super.detach(),this._tileStrategy.destroy(),this._fetchQueue.clear(),this.container.removeAllChildren(),this._fetchQueue=this._tileStrategy=this._tileInfoView=null}moveStart(){this.requestUpdate()}viewChange(){this.requestUpdate()}moveEnd(){this.requestUpdate()}createFetchPopupFeaturesQueryGeometry(e,i){return(0,j.K)(e,i,this.view)}doRefresh(){var e=this;return(0,d.Z)(function*(){e.updateRequested||e.suspended||(e._fetchQueue.reset(),e._tileStrategy.tiles.forEach(i=>e._enqueueTileFetch(i)),e.notifyChange("updating"))})()}isUpdating(){var e;return(null==(e=this._fetchQueue)?void 0:e.length)>0}acquireTile(e){const i=this._bitmapView.createTile(e),r=i.bitmap;return[r.x,r.y]=this._tileInfoView.getTileCoords(K,i.key),r.resolution=this._tileInfoView.getTileResolution(i.key),[r.width,r.height]=this._tileInfoView.tileInfo.size,this._enqueueTileFetch(i),this._bitmapView.addChild(i),this.requestUpdate(),i}releaseTile(e){this._fetchQueue.abort(e.key.id),this._bitmapView.removeChild(e),e.once("detach",()=>e.destroy()),this.requestUpdate()}fetchTile(e,i){var r=this;return(0,d.Z)(function*(){const M="tilemapCache"in r.layer?r.layer.tilemapCache:null,g=!(0,x.Wi)(i)&&i.signal;if(!M)try{return yield r._fetchImage(e,g)}catch(y){if(!(0,s.D_)(y)&&!r.resampling)return r._createBlankImage();throw y}const v=new P.Z(0,0,0,0);let I;try{if(yield M.fetchAvailabilityUpsample(e.level,e.row,e.col,v,{signal:g}),v.level!==e.level&&!r.resampling)return r._createBlankImage();I=yield r._fetchImage(v,g)}catch(y){if((0,s.D_)(y))throw y;I=yield r._fetchImage(e,g)}const{level:T,row:u,col:p}=v;return r.resampling&&T!==e.level?r._resampleImage(I,T,u,p,e.level,e.row,e.col):I})()}_enqueueTileFetch(e){var i=this;return(0,d.Z)(function*(){if(!i._fetchQueue.has(e.key.id)){try{const r=yield i._fetchQueue.push(e.key);e.bitmap.source=r,e.bitmap.width=i._tileInfoView.tileInfo.size[0],e.bitmap.height=i._tileInfoView.tileInfo.size[1],e.once("attach",()=>i.requestUpdate())}catch(r){(0,s.D_)(r)||A.error(r)}i.requestUpdate()}})()}_fetchImage(e,i){var r=this;return(0,d.Z)(function*(){return r.layer.fetchTile(e.level,e.row,e.col,{signal:i})})()}_resampleImage(e,i,r,M,g,v,I){const T=this._tileInfoView.tileInfo.size,u=this._tileInfoView.getTileResolution(i),p=this._tileInfoView.getTileResolution(g);let y=this._tileInfoView.getLODInfoAt(g);const L=y.getXForColumn(I),Q=y.getYForRow(v);y=this._tileInfoView.getLODInfoAt(i);const G=y.getXForColumn(M),Y=y.getYForRow(r),X=Math.round((L-G)/u),_=Math.round(-(Q-Y)/u),N=Math.round(T[0]*(p/u)),H=Math.round(T[1]*(p/u)),B=this._createBlankImage();return B.getContext("2d").drawImage(e,X,_,N,H,0,0,T[0],T[1]),B}_createBlankImage(){const e=this._tileInfoView.tileInfo.size,i=document.createElement("canvas");return[i.width,i.height]=e,i}};(0,V._)([(0,a.Cb)()],D.prototype,"resampling",null),D=(0,V._)([(0,o.j)("esri.views.2d.layers.TileLayerView2D")],D);var W=D},16204:(z,R,l)=>{l.d(R,{K:()=>x}),l(73513);var V=l(60305),w=l(4820),C=l(82059);function x(h,c,o,f=new C.Z){let m;if("2d"===o.type)m=c*o.resolution;else if("3d"===o.type){const b=o.overlayPixelSizeInMapUnits(h),S=o.basemapSpatialReference;m=(0,V.pC)(S)&&!S.equals(o.spatialReference)?(0,w.c9)(S)/(0,w.c9)(o.spatialReference):c*b}const E=h.x-m,P=h.y-m,U=h.x+m,Z=h.y+m,{spatialReference:F}=o;return f.xmin=Math.min(E,U),f.ymin=Math.min(P,Z),f.xmax=Math.max(E,U),f.ymax=Math.max(P,Z),f.spatialReference=F,f}new C.Z}}]);