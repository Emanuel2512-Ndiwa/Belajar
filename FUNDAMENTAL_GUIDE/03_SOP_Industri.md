# 🏢 SOP INDUSTRI - SISTEM DESIGN & DEVELOPMENT
## Standar Operating Procedure untuk Fresh Graduate & WFH Teams
**Referensi:** Google Engineering Practices, Microsoft Software Development Lifecycle (SDLC), Agile Manifesto

---

## 📋 SOP INDUSTRI TAHAPAN DEVELOPMENT

### **FASE 1: REQUIREMENTS GATHERING (Minggu 1-2)**

**Peserta:** Product Manager, Software Architect, Developer Lead

**Deliverables:**
- [ ] Requirements Document (Functional + Non-Functional)
- [ ] User Stories / Use Cases
- [ ] Acceptance Criteria
- [ ] Data Dictionary
- [ ] High-Level Architecture Diagram

**Artefak:**
```
TEMPLATE REQUIREMENT DOCUMENT:

PROJECT: Sistem Inventori Toko
CREATED: 2026-04-05
AUTHOR: Requirement Analyst
VERSION: 1.0

1. BUSINESS REQUIREMENT
   - Background
   - Business Goals
   - Success Metrics

2. FUNCTIONAL REQUIREMENT
   - Feature 1: Add Barang
     * Input: nama, harga, kategori, stok
     * Output: success message, barang di-list
     * Constraint: harga > 0, stok >= 0
   
   - Feature 2: Search Barang
     * Input: nama barang
     * Output: detail barang atau "not found"
     * Note: case-insensitive

3. NON-FUNCTIONAL REQUIREMENT
   - Performance: Response time < 1 second
   - Scalability: Support min 1000 barang
   - Security: Akses kontrol untuk admin
   - Availability: 99.9% uptime

4. CONSTRAINT & ASSUMPTION
   - Desktop application (tidak mobile)
   - Database: File-based (tidak SQL)
   - User: Internal staff only
```

---

### **FASE 2: DESIGN & REVIEW (Minggu 3)**

**Peserta:** Software Architect, Senior Developer, Tech Lead

**Activities:**
1. [ ] Buat Class Diagram (UML)
2. [ ] Buat Sequence Diagram
3. [ ] Buat Database Design (ER Diagram)
4. [ ] Buat API Specification
5. [ ] Design Review Meeting

**Deliverables:**
```
DESIGN DOCUMENT CHECKLIST:

□ High-Level Architecture Diagram
  - Component diagram
  - Technology stack
  
□ Class Diagram
  - Semua class dengan attribute & method
  - Relationships (inheritance, composition)
  - Multiplicity
  
□ Sequence Diagram
  - Happy path scenarios
  - Error handling scenarios
  
□ Database Design
  - ER Diagram
  - Table specifications
  - Data types & constraints
  
□ API Design (jika ada REST API)
  - Endpoints specification
  - Request/Response format
  - Error handling

□ Design Decision Document
  - Why this design?
  - Alternative considered
  - Trade-offs
```

**Template Design Review Meeting:**
```
DESIGN REVIEW MEETING - Inventori System
Date: 2026-04-15
Attendees: Architect, Lead Dev, Senior Dev, QA Lead

TOPICS DISCUSSED:
1. Class structure - APPROVED ✓
2. Polymorphism approach - APPROVED ✓
3. Data persistence strategy - DISCUSSION NEEDED
4. Error handling approach - NEED CLARIFICATION

ACTION ITEMS:
- [ ] Update diagram untuk error handling
- [ ] Research tentang file vs database
- [ ] Provide alternative approach

DECISION MADE:
- Use ArrayList for in-memory storage (MVP)
- Implement Reportable interface for future persistence
```

---

### **FASE 3: DEVELOPMENT (Minggu 4-6)**

**Peserta:** Developer, QA, Senior Developer

**Development Standard:**

**A. Code Review Process**
```
REQUIREMENT: SEMUA code harus di-review sebelum merge

1. Developer create feature branch
   $ git checkout -b feature/add-search-barang

2. Developer push code
   $ git push origin feature/add-search-barang

3. Developer create PULL REQUEST (PR) dengan:
   - Deskripsi fitur
   - Testing evidence (screenshot/test report)
   - Reference ke issue/requirement

4. Reviewer check:
   - [ ] Sesuai requirement?
   - [ ] Code style konsisten?
   - [ ] Have unit tests?
   - [ ] No duplicate code?
   - [ ] Performance OK?
   - [ ] Security OK?
   - [ ] Documentation clear?

5. Reviewer approve/request changes

6. Merge to main/develop branch
```

**B. Coding Standards**
```
NAMING CONVENTION:
✓ Classes:       PascalCase      (Barang, Seller)
✓ Methods:       camelCase       (getNama, addBarang)
✓ Variables:     camelCase       (totalNilai, userInput)
✓ Constants:     UPPER_SNAKE     (MAX_STOCK, TAX_RATE)
✓ Interfaces:    IPrefixed       (IReportable, ISearchable)

CODE STYLE:
✓ Indentation: 4 spaces
✓ Line length: Max 100 characters
✓ Comments: Meaningful, not obvious code
✓ Brackets: Opening di end of line
✓ Method length: < 50 lines (if possible)

EXAMPLE:
```
public class InventoryManager {
    private static final int MAX_SELLERS = 1000;
    private ArrayList<Seller> sellers;
    
    public void displayAllBarang() {
        int no = 1;
        for (int i = 0; i < sellers.size(); i++) {
            // Implementation
        }
    }
}
```
```

**C. Documentation Standard**
```
JAVADOC UNTUK SETIAP PUBLIC METHOD:

/**
 * Menambahkan barang baru ke inventori seller
 * 
 * @param barang - Objek Barang yang akan ditambahkan
 * @return true jika berhasil, false jika duplikat
 * @throws IllegalArgumentException jika barang null
 * 
 * @example
 * Barang b = new Elektronik("Laptop", 5000000);
 * seller.addBarang(b);  // returns true
 */
public boolean addBarang(Barang barang) {
    // Implementation
}
```

**D. Testing Standard**
```
REQUIREMENT: Minimum 80% code coverage untuk business logic

1. Unit Test
   - Test setiap method secara individual
   - Test happy path, edge case, error case
   
2. Integration Test
   - Test interaction antar class
   
3. Acceptance Test
   - Test sesuai requirement/user story

CONTOH TEST CASE:
```
// Test: Add barang dengan harga valid
public void testAddBarangValidPrice() {
    Barang barang = new Elektronik("Laptop", 5000000);
    assertTrue(seller.addBarang(barang));
    assertEquals(1, seller.getTotalBarang());
}

// Test: Add barang dengan harga negatif
public void testAddBarangNegativePrice() {
    Barang barang = new Elektronik("Laptop", -5000000);
    seller.addBarang(barang);
    assertEquals(0, seller.getTotalBarang());
}

// Test: Search barang tidak ada
public void testSearchBarangNotFound() {
    Barang result = seller.searchBarang("NonExistent");
    assertNull(result);
}
```
```

---

### **FASE 4: TESTING & QA (Minggu 6-7)**

**Peserta:** QA Engineer, Tester, Developer

**Activities:**
1. [ ] Functional Testing (sesuai requirement)
2. [ ] Non-Functional Testing (performance, load)
3. [ ] Regression Testing
4. [ ] User Acceptance Testing (UAT)

**Test Plan Template:**
```
TEST PLAN - Inventori System
Date Created: 2026-04-20
Test Manager: QA Lead

SCOPE:
- Add Barang feature
- Search Barang feature
- Update Stok feature
- Report feature
(Note: Exclude authentication for MVP)

TEST SCHEDULE:
- Unit Test: Week 1 (by Developer)
- Integration Test: Week 2 (by Developer+QA)
- System Test: Week 3 (by QA)
- UAT: Week 4 (by Client)

TEST CASES EXECUTED:
Total: 35 test cases
Passed: 32 ✓
Failed: 2 ✗ (Priority: Medium)
Blocked: 1 ⏸ (Waiting for dev fix)

BUG FOUND:
[BUG-001] Search case-sensitive (CRITICAL)
[BUG-002] Negative stok accepted (HIGH)
[BUG-003] UI layout misaligned (LOW)

RESOLUTION:
- BUG-001: Fixed & re-tested ✓
- BUG-002: Fixed & re-tested ✓
- BUG-003: Deferred to next release
```

---

### **FASE 5: DEPLOYMENT (Minggu 8)**

**Peserta:** DevOps, Release Manager, Senior Dev

**Deployment Checklist:**
```
PRE-DEPLOYMENT:
□ All tests passed (100%)
□ Code review approved
□ Documentation complete
□ Release notes ready
□ Backup taken
□ Rollback plan ready

DEPLOYMENT:
□ Deploy to staging first
□ Run smoke test on staging
□ Get stakeholder approval
□ Deploy to production
□ Monitor for errors

POST-DEPLOYMENT:
□ Run health check
□ Monitor application metrics
□ User notification delivered
□ Log deployment event
□ Archive release artifacts
```

**Release Notes Example:**
```
RELEASE NOTES - v1.0.0
Date: 2026-05-01

NEW FEATURES:
- Add Barang (Support 3 categories: Elektronik, Fashion, Makanan)
- Search Barang (Case-insensitive)
- View All Barang
- Update Stok
- Generate Report (Total & By Category)

BUG FIXES:
- Fix negative stok validation
- Fix duplicate seller ID handling

KNOWN ISSUES:
- Data tidak persist setelah aplikasi close (Fix di v1.1)
- Report tidak support export to PDF (Planned for v1.2)

UPGRADE NOTES:
- Backup data before upgrade
- No database migration needed
```

---

### **FASE 6: MAINTENANCE & MONITORING (Ongoing)**

**Peserta:** DevOps, QA, Support Team

**Activities:**
1. [ ] Monitor application errors/logs
2. [ ] Track performance metrics
3. [ ] Collect user feedback
4. [ ] Plan bug fixes & improvements
5. [ ] Plan next release/features

**Monitoring Dashboard Metric:**
```
KEY METRICS TO MONITOR:
- Application uptime: > 99.9%
- Response time: < 1 second
- Error rate: < 0.1%
- Memory usage: < 500MB
- CPU usage: < 70%

ALERT THRESHOLDS:
- Error rate > 1% → Alert
- Response time > 5 sec → Alert
- Memory > 800MB → Alert
- Uptime < 99% → Critical Alert
```

---

## 📊 DEVELOPMENT TIMELINE CONTOH

```
PROJECT: Sistem Inventori Toko
DURATION: ~8 minggu

WEEK 1-2 (Apr 5-18)
├─ Requirements gathering ✓
├─ Stakeholder alignment ✓
└─ Design kickoff

WEEK 3-4 (Apr 19-May 2)
├─ Class Diagram finalized ✓
├─ Code review preparation ✓
└─ Development sprint 1 begin

WEEK 5-6 (May 3-16)
├─ Core features development ✓
├─ Unit testing ✓
└─ Code review & merge

WEEK 7 (May 17-23)
├─ System testing
├─ Bug fixing
└─ Documentation

WEEK 8 (May 24-30)
├─ UAT & refinement
├─ Deployment prep
└─ Go-live (May 30)

WEEK 9+ (Ongoing)
├─ Monitoring & support
└─ Plan v1.1 features
```

---

## 🎯 TEAM STRUCTURE & ROLES

```
PROJECT TEAM - Inventory System

PROJECT MANAGER (1)
├─ Product Roadmap
├─ Stakeholder communication
└─ Timeline management

TECH LEAD / ARCHITECT (1)
├─ Design & architecture
├─ Code review approval
└─ Technical decision making

DEVELOPERS (2-3)
├─ Code development
├─ Unit testing
└─ Code review (peer)

QA ENGINEER (1)
├─ Test planning
├─ Test execution
└─ Bug reporting

DEVOPS / INFRA (1) [If needed]
├─ Deployment
├─ Infrastructure setup
└─ Monitoring
```

---

## 📝 REQUIRED DOCUMENTATION

**Minimal dokumentasi yang harus ada:**

```
01_Requirements_Document.pdf
├─ Functional requirements
├─ Non-functional requirements
└─ User stories

02_Design_Document.pdf
├─ Class diagram
├─ Sequence diagram
└─ Architecture diagram

03_API_Specification.pdf (jika ada REST API)
├─ Endpoint definitions
├─ Request/Response format
└─ Error handling

04_Test_Plan.pdf
├─ Test strategy
├─ Test cases
└─ Test results

05_User_Manual.pdf
├─ How to use
├─ Screenshots
└─ Troubleshooting

06_Developer_Guide.pdf
├─ How to build
├─ How to run
├─ Project structure
└─ Coding standards

07_Deployment_Guide.pdf
├─ Prerequisites
├─ Step-by-step deployment
└─ Rollback procedure

08_Architecture_Decision_Log.pdf
├─ Decision made
├─ Why that decision
└─ Alternatives considered
```

---

## 🚨 COMMON PITFALLS IN PRACTICE

| Pitfall | Dampak | Solusi |
|---------|--------|--------|
| Skip design phase | Rework code multiple times | Enforce design review |
| No code review | Bug slip to production | Mandatory CR before merge |
| Insufficient testing | Critical bug di production | Automated test + manual test |
| Poor documentation | Sulit onboarding dev baru | Template mandatory docs |
| No version control | Code conflict | Use Git best practices |
| Tidak komunikasi | Miskomunikasi tim | Daily standup + docs |

---

## 🏆 BEST PRACTICES

**DO:**
✅ Write design before code
✅ Review code diligently
✅ Test comprehensively
✅ Document as you code
✅ Communicate early, often
✅ Version everything
✅ Plan deployment carefully
✅ Monitor after deployment

**DON'T:**
❌ Code first, design later
❌ Skip code review
❌ "We'll test later"
❌ Assume people know what code does
❌ Deploy without testing
❌ Delete old code without backup
❌ Change production without plan
❌ Ignore monitoring alerts

---

## 📞 ESCALATION PATH

```
ISSUE SEVERITY:

CRITICAL (P0) - Down/Broken features
└─ Escalate to: Tech Lead → Project Manager → stakeholder
   Action time: Immediate (< 1 hour)

HIGH (P1) - Major feature broken
└─ Escalate to: Tech Lead → Developer team
   Action time: Same day (< 4 hours)

MEDIUM (P2) - Minor feature broken
└─ Escalate to: Developer team
   Action time: Next sprint

LOW (P3) - Enhancement / Nice to have
└─ Escalate to: Product manager
   Action time: Backlog for future sprint
```

---

## 💡 KESIMPULAN SOP INDUSTRI

1. **Phases:** Requirements → Design → Dev → Test → Deploy → Monitor
2. **Documentation:** Mandatory di setiap fase
3. **Code Review:** Non-negotiable
4. **Testing:** Automated + manual
5. **Communication:** Daily standup, clear documentation
6. **Quality:** Consistency & standards untuk sustainability

**Tujuan:** Deliver quality software on time, on budget, with good maintainability.
