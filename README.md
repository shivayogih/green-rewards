# 🌱 GreenRewards

**Eco + Coin Concept** — A gamified mobile and web platform that motivates users to adopt eco-friendly habits while earning redeemable eco-coins.  

## 📖 Overview
GreenRewards is a lightweight, engaging app that helps users reduce their carbon footprint by tracking eco-friendly activities like walking, cycling, recycling, and reducing plastic use.  
Users earn **eco-coins** through manual or automated activity logging, daily/weekly challenges, and community participation. These coins can be redeemed for coupons and vouchers from partner merchants.  

The project is designed to be **offline-first**, **secure**, and **scalable**, with Firebase as the backend and Jetpack Compose (Android + Multiplatform) for UI.  

---

## 🎯 Goals & Success Metrics
- **Retention:** 20% user retention after 30 days  
- **Adoption:** 1000 active users within 3 months post-launch  
- **Partnerships:** 50 merchant partners in Year 1  
- **Monetization:** Commission on coupon redemptions, premium features, ads  

**Key KPIs:** DAU, retention, coins earned per user, coupon redemptions, merchant payouts, ARPU  

---

## ✨ Features

### 👤 User Features
- Authentication (Email/Google/Phone OTP, password reset)  
- Profile with eco-goals, badges, progress  
- Activity tracking (manual + step counter + cycling + Google Fit sync)  
- Eco-coin wallet with transaction history  
- Marketplace for partner offers and coupon redemptions  
- Challenges, streaks, leaderboards  
- Notifications (reminders, reward alerts, merchant promos)  
- Privacy controls & preferences  

### 🏪 Merchant/Admin Features
- Merchant portal for listing offers  
- Admin portal for approvals & analytics  
- Coupon redemption validation  

### ⚙️ System Features
- Offline-first activity logging (Room + Firestore sync)  
- Fraud detection  
- Role-based access control  
- Analytics & A/B testing  

---

## 📱 User Flow

1. **Onboarding & Authentication** → Splash → Welcome → Register/Login → Profile Setup  
2. **Home Dashboard** → Eco-coin meter, quick log, eco-score, wallet/marketplace shortcuts  
3. **Log Activity** → Manual entry or automated (step counter, cycling, location, Google Fit)  
4. **Wallet** → Balance + transaction history, redeem in marketplace  
5. **Marketplace** → Browse offers, redeem with eco-coins  
6. **Challenges & Leaderboards** → Daily/weekly missions + progress, global/local ranks  
7. **Profile & Settings** → Goals, badges, notifications, privacy  
8. **Notifications & Deep Links** → Activity completion, new offers, reward alerts  

---

## 🛠️ Tech Stack

- **Frontend (Client):**  
  - Android (Kotlin, Jetpack Compose)  
  - Web (Compose Multiplatform / PWA)  
  - Modular architecture (ui-core, feature-auth, feature-activity, feature-wallet, etc.)  

- **Backend (Cloud):**  
  - Firebase (Auth, Firestore, Cloud Functions, Storage, FCM)  
  - Room + WorkManager for offline sync  

- **Architecture:**  
  - MVVM (primary) + MVI for wallet/marketplace flows  
  - Koin for dependency injection  

- **Security:**  
  - EncryptedSharedPreferences  
  - Android Keystore  
  - Firestore rules  

---

## 🔗 APIs (Cloud Functions)

- `awardCoinsOnActivity()`  
- `redeemOffer()`  
- `syncPendingActivities()`  
- `generateReferralLink()`  
- `analyzeProductRecyclability(barcode)`  
- `logTransportService(type, distance)`  

---

## 📊 Reward System

- **Product Scanning:**  
  - <40% recyclable → 1 coin  
  - 40–70% recyclable → 3 coins  
  - >70% recyclable → 5 coins + badge  

- **Transport Logging:**  
  - Bus/train → 2 coins per 5 km  
  - Cycling/walking → 3 coins per 5 km  
  - Carpool → 1 coin per 5 km  
  - Private car/taxi → 0 coins  

- **Bonus Multipliers:**  
  - Daily streak (7 days) → +10% coins  
  - Special challenges → +10 coins  

---

## 👥 Team (MVP)

- Android Developer (Kotlin/Compose): 1  
- Backend Developer (Firebase/Cloud Functions): 1  
- Full-Stack Web Developer (Merchant Portal): 1  
- UI/UX Designer: 1  
- QA Engineer: 1  
- PM (part-time): 1  

---

## 💰 Budget Estimate (3-month MVP)

- Developer salaries: ₹15–20L ($18–24k)  
- Firebase usage: $200–500/month  
- Design & assets: $1,000–2,000  
- Marketing: $3,000–5,000  
- Contingency: 10–15%  

**Total Estimated Cost:** ~$25k–35k USD (₹20–30L)  

---

## 🗓️ Roadmap (MVP, 12 weeks)

- **Sprint 0:** Setup, design, CI/CD  
- **Sprint 1:** Auth + Onboarding  
- **Sprint 2:** Activity logging + Wallet  
- **Sprint 3:** Marketplace browsing + FCM setup  
- **Sprint 4:** Redemption + Cloud Functions  
- **Sprint 5:** Offline sync + Merchant portal  
- **Sprint 6:** QA, polish, security, release  

---

## 🔒 Security & Privacy

- Firebase Auth + claims for role-based access  
- All local data encrypted  
- Server-side activity validation  
- GDPR compliance (account deletion & export)  

---

## 💵 Monetization

- Commission on coupon redemptions  
- Premium subscriptions (ad-free, exclusive offers)  
- AdMob integration (banner/native ads)  
- Sponsored eco-challenges  

---

## ⚠️ Risks & Mitigation

- **Fraud:** Server-side validation, attestation APIs  
- **Merchant adoption:** Pilot with eco-friendly local businesses  
- **User retention:** Gamification, streaks, leaderboards  
- **Scaling costs:** Optimize Firestore usage, caching  

---

## 🚀 Next Steps

- Wireframe storyboard in Figma  
- Setup Firebase project + security rules  
- Scaffold multimodule Android project  
- Begin Sprint 1 implementation  
- Partner outreach with eco-friendly merchants  

---

## 📌 License

This project is currently in planning/prototype stage. License will be decided before public release.  
